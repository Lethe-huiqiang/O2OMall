package com.jixie.action.forum;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;

import com.gzbugu.common.query.PageModel;
import com.jixie.action.BaseAction;
import com.jixie.action.UploadHelper;
import com.jixie.action.users.UsersHelper;
import com.jixie.bean.FileSource;
import com.jixie.bean.ForumPlate;
import com.jixie.bean.SharePost;
import com.jixie.bean.Users;
import com.jixie.utils.Utils;
import com.opensymphony.xwork2.ActionContext;

public class SharePostAction extends BaseAction{
	
	private SharePost sharePost;
	private String parentPostId;//父贴id
	private String sharePostId;//帖子id
	private String postTitle;//帖子标题
	private String postArea;//帖子板块
	private PageModel pageModel;//
	
	private ForumPlate forumPlate;//创建论坛版块
	
	private File[] imgFile;//上传图片
	private String[] imgFileFileName;//上传图片名字
	private String dir;//页面中标明 的上传文件类型
	private String imageFileDir;//上传图片存储位置
	private String mediaFileDir;//上传视频存储位置
	/**
	 * @category 建帖页面
	 */
	public String createSharePostUI(){
		
		String hql = "from ForumPlate fp where";
		
		return "createSharePostUI";
	}
	
	
	
	/**
	 * @category 建帖方法
	 */
	public String createSharePost(){
		
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		try{
			String id = Utils.getUUID();
			sharePost.setId(id);
			sharePost.setPostId(id);
			sharePost.setOwnerId(UsersHelper.getUsersFromSession().getId());
			sharePost.setCreateTime(Utils.getCurrentTimestamp());
			sharePost.setParentPostId(id);
			//sharePost.setSharePostOwner(UsersHelper.getUsersFromSession().getNickname());
			commonService.save(sharePost);
			ActionContext.getContext().getValueStack().push(sharePost);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "createSharePost";
		
	}

	/**
	 * @category 回帖
	 */
	public void answerSharePost(){
		
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		try{
			
			String id = Utils.getUUID();
			sharePost.setId(id);
			/*sharePost.setPostId(sharePostId);
			sharePost.setTitle(postTitle);
			sharePost.setArea(postArea);*/
			sharePost.setOwnerId(UsersHelper.getUsersFromSession().getId());
			sharePost.setCreateTime(Utils.getCurrentTimestamp());
			//sharePost.setSharePostOwner(UsersHelper.getUsersFromSession().getNickname());
		
		
			commonService.save(sharePost);
			ActionContext.getContext().getValueStack().push(sharePost);
			this.sendMsgAjax("success", "utf-8");
		}catch(Exception e){
			e.printStackTrace();
			try {
				this.sendMsgAjax("fail", "utf-8");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * @category 查看帖子
	 * @return
	 */
	public String readSharePost(){
		
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		try{
			if(sharePostId==null){
				sharePostId = sharePost.getId();
			}
			String hql_parent = "from SharePost sp where sp.id=? and sp.id=sp.parentPostId";//帖子id=父贴id,则为一个建帖记录
			List<SharePost> post = commonService.findListByHQL(hql_parent,sharePostId);//查到建帖记录
			
			SharePost createSharePost = null;
			if(post.size()>0){
				createSharePost = post.get(0);//建帖记录
			}
		
			String hql_child = "from SharePost sp where sp.parentPostId=? and id<>? order by sp.createTime";//跟帖记录
			List<SharePost> answerPost = commonService.findListByHQL(hql_child,createSharePost.getId(),createSharePost.getId());
			
			String hql_child_child = "from SharePost sp where sp.postId = ? and sp.parentPostId <> ? order by sp.createTime";//回复楼层记录
			List<SharePost> childAnswerPost = commonService.findListByHQL(hql_child_child, createSharePost.getId(), createSharePost.getId());
			
			//取得回复跟帖人昵称
			for(int u=0; u<childAnswerPost.size(); u++){
				Users users = commonService.findById(childAnswerPost.get(u).getOwnerId(), new Users());
				childAnswerPost.get(u).setSharePostOwner(users.getNickname());
			}
			
			//取得发帖人昵称
			for(int u=0; u<answerPost.size(); u++){
				Users users = commonService.findById(answerPost.get(u).getOwnerId(), new Users());
				answerPost.get(u).setSharePostOwner(users.getNickname());
			}
			
			int answerPostSize = answerPost.size();
			int childAnswerPostSize = childAnswerPost.size();
			
			if(answerPostSize > 0 && childAnswerPostSize > 0){
				
				for(int i = 0; i<answerPostSize; i++){
					
					ArrayList<SharePost> childAnswerList = new ArrayList<SharePost>();//在每条跟帖中传进回复帖子的记录
					for(int j = 0; j<childAnswerPostSize; j++){
						if(childAnswerPost.get(j).getParentPostId().equals(answerPost.get(i).getId())){
							childAnswerList.add(childAnswerPost.get(j));
						}	
					}
					answerPost.get(i).setChildAnswerList(childAnswerList);//将回复帖子的记录set进跟帖中
					//childAnswerList.clear();
				}
			}
			
			Users users = UsersHelper.getUsersFromSession();
			
			ActionContext ctx = ActionContext.getContext();
			Map<String, Object> request = (Map<String, Object>) ctx.get("request");
			request.put("createSharePost", createSharePost);
			request.put("answerPost", answerPost);
			//ActionContext.getContext().getValueStack().push(users);
			request.put("users", users);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "readSharePost";
	}

	/**
	 * @category 查看帖子列表
	 * @return
	 */
	public String viewSharePostList(){
		
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		try{
			String hql = "from SharePost sp where sp.id = sp.parentPostId";
			
			/*PageModel pm = new PageModel();
			pm.setCurrentPage(pageModel == null ? 1 : pageModel.getCurrentPage());*/
			
			List<SharePost> spList = commonService.findListByHQL(hql);
			
			ActionContext ctx = ActionContext.getContext();
			Map<String, Object> request = (Map<String, Object>) ctx.get("request");
			request.put("spList", spList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "viewSharePostList";
	}
	
	/**
	 * @category 创建板块
	 * @return
	 */
	public String createForumPlate(){
		
		try{
			forumPlate.setId(Utils.getUUID());
			forumPlate.setCreateTime(Utils.getCurrentTimestamp());
		
			commonService.save(forumPlate);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * @category 上传图片报错信息
	 * @param message
	 * @return
	 */
	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		System.out.println(obj.toJSONString());
		return obj.toJSONString();
	}
	
	/**
	 * @category 上传图片
	 */
	public void pictureUpload(){
		
		long maxSize = 5000000 ;//图片最大5M
		//定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		String fileDir = "upload";
		try{
			HttpServletResponse response =  ServletActionContext.getResponse();
			HttpServletRequest request = ServletActionContext.getRequest();
			PrintWriter out = response.getWriter();
			
			for(int i = 0; i < imgFile.length; i++){
				//检查文件大小
				if(imgFile[i].length() > maxSize){
					out.println(getError("上传文件大小超过限制。"));
					return;
				}
				//检查扩展名
				String fileExt = imgFileFileName[i].substring(imgFileFileName[i].lastIndexOf(".") + 1).toLowerCase();
				if(!Arrays.<String>asList(extMap.get(dir).split(",")).contains(fileExt)){
					out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dir) + "格式。"));
					return;
				}
				
				
				if(imageFileDir!=null&&mediaFileDir==null){
					fileDir = "imageFileDir";
				}else if(imageFileDir==null&&mediaFileDir!=null){
					fileDir = "mediaFileDir";
				}
				List<FileSource> list = UploadHelper.getInstance().uploadMultipleFile(imgFile,imgFileFileName,fileDir);
				
				String path = request.getContextPath();
				String saveUrl =  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/" + list.get(0).getPath();
				
				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				
				obj.put("url", saveUrl);
				out.println(obj.toJSONString());
				System.out.println(obj.toJSONString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @category 上传图片
	 * @return
	 */
	/*public void picUpload(){
		
		
		//文件保存目录路径
		String savePath = pageContext.getServletContext().getRealPath("/") + "fileSource/";

		//文件保存目录URL
		String saveUrl  = request.getContextPath() + "/fileSource/";

		//定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		//最大文件大小
		long maxSize = 1000000;

		response.setContentType("text/html; charset=UTF-8");

		if(!ServletFileUpload.isMultipartContent(request)){
			out.println(getError("请选择文件。"));
			return;
		}
		//检查目录
		File uploadDir = new File(savePath);
		if(!uploadDir.isDirectory()){
			out.println(getError("上传目录不存在。"));
			return;
		}
		//检查目录写权限
		if(!uploadDir.canWrite()){
			out.println(getError("上传目录没有写权限。"));
			return;
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if(!extMap.containsKey(dirName)){
			out.println(getError("目录名不正确。"));
			return;
		}
		//创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List items = upload.parseRequest(request);
		Iterator itr = items.iterator();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			String fileName = item.getName();
			long fileSize = item.getSize();
			if (!item.isFormField()) {
				//检查文件大小
				if(item.getSize() > maxSize){
					out.println(getError("上传文件大小超过限制。"));
					return;
				}
				//检查扩展名
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
					out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
					return;
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
				try{
					File uploadedFile = new File(savePath, newFileName);
					item.write(uploadedFile);
				}catch(Exception e){
					System.out.println("写文件失败");
					out.println(getError("上传文件失败。"));
					return;
				}

				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				obj.put("url", saveUrl + newFileName);
				out.println(obj.toJSONString());
				System.out.println(obj.toJSONString());
			}
		}
		
		private String getError(String message) {
			JSONObject obj = new JSONObject();
			obj.put("error", 1);
			obj.put("message", message);
			System.out.println(obj.toJSONString());
			return obj.toJSONString();
		}
		
	}*/
	
	public SharePost getSharePost() {
		return sharePost;
	}

	public void setSharePost(SharePost sharePost) {
		this.sharePost = sharePost;
	}

	public String getParentPostId() {
		return parentPostId;
	}

	public void setParentPostId(String parentPostId) {
		this.parentPostId = parentPostId;
	}

	public String getSharePostId() {
		return sharePostId;
	}

	public void setSharePostId(String sharePostId) {
		this.sharePostId = sharePostId;
	}


	public String getPostTitle() {
		return postTitle;
	}


	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}


	public String getPostArea() {
		return postArea;
	}


	public void setPostArea(String postArea) {
		this.postArea = postArea;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public ForumPlate getForumPlate() {
		return forumPlate;
	}

	public void setForumPlate(ForumPlate forumPlate) {
		this.forumPlate = forumPlate;
	}







	public String getDir() {
		return dir;
	}



	public void setDir(String dir) {
		this.dir = dir;
	}



	public String[] getImgFileFileName() {
		return imgFileFileName;
	}



	public File[] getImgFile() {
		return imgFile;
	}



	public void setImgFile(File[] imgFile) {
		this.imgFile = imgFile;
	}



	public void setImgFileFileName(String[] imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}



	public String getImageFileDir() {
		return imageFileDir;
	}



	public String getMediaFileDir() {
		return mediaFileDir;
	}



	public void setMediaFileDir(String mediaFileDir) {
		this.mediaFileDir = mediaFileDir;
	}



	public void setImageFileDir(String imageFileDir) {
		this.imageFileDir = imageFileDir;
	}


}

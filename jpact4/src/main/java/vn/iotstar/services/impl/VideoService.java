package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IVideoDao;
import vn.iotstar.dao.impl.VideoDao;
import vn.iotstar.entity.Video;
import vn.iotstar.services.IVideoService;

public class VideoService implements IVideoService {
	IVideoDao cateDao = new VideoDao();

	@Override
	public int count() {
		return cateDao.count();
	}

	@Override
	public List<Video> findByVideoname(String videoname) {
		return cateDao.findByVideoname(videoname);
	}

	@Override
	public Video findById(String videoid) {
		return cateDao.findById(videoid);
	}

	@Override
	public void delete(String videoid) throws Exception {
		cateDao.delete(videoid);
	}

	@Override
	public void update(Video video) {
		cateDao.update(video);
	}

	@Override
	public List<Video> findAll(int page, int pagesize) {
		return cateDao.findAll(page, pagesize);
	}

	@Override
	public List<Video> findAll() {
		return cateDao.findAll();
	}

	@Override
	public void insert(Video video) {
		cateDao.insert(video);
	}

}

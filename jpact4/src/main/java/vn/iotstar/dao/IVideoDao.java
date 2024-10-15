package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Video;

public interface IVideoDao {

	int count();

	List<Video> findByVideoname(String videoname);

	Video findById(String videoid);

	void delete(String videoid) throws Exception;

	void update(Video video);

	List<Video> findAll(int page, int pagesize);

	List<Video> findAll();

	void insert(Video video);

}

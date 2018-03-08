package phm.GrProject.base;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


/**
 * Service层基类，定义通用的增，删，改，查功能接口。
 * 
 * @author Xiongyan
 * @date 2015年5月6日 下午5:41:57
 * @version 0.0.1
 * @param <T>
 */
@Service
@Transactional
public interface BaseService<T> {
	/**
	 * 保存数据
	 * 
	 * @author Xiongyan
	 * @return 
	 * @date 2015年5月6日 下午5:42:42
	 * @throws
	 * @return void 返回类型
	 */
	public void save(T t);

	/**
	 * 删除数据
	 * 
	 * @author Xiongyan
	 * @date 2015年5月6日 下午5:43:08
	 * @throws
	 * @return void 返回类型
	 */
	public void delete(Serializable id);
	
	public void delete(T t);

	/**
	 * 更新数据
	 * 
	 * @author Xiongyan
	 * @date 2015年5月6日 下午5:43:19
	 * @throws
	 * @return void 返回类型
	 */
	public void update(T t);

	/**
	 * 根据ID获取数据
	 * 
	 * @author Xiongyan
	 * @date 2015年5月6日 下午5:43:30
	 * @throws
	 * @return T 返回类型
	 */
	public T get(Serializable id);

	/**
	 * 获取所有的数据
	 * 
	 * @author Xiongyan
	 * @date 2015年5月6日 下午5:43:52
	 * @throws
	 * @return List<T> 返回类型
	 */
	public List<T> getAll();
	/**
	 * 
	 * <h1>标题</h1>
	 * <p>内容</p>
	 * @param sql
	 * @param entity
	 * @return
	 */
	public List<T> SQL(String sql, Class<T> entity);
	/**
	 * 
	 * <h1>标题</h1>
	 * <p>内容</p>
	 * @param hql
	 * @return
	 */
	public List<T> HQL(String hql) ;
	/**
	 * 获取page 总页数
	 * <h1>标题</h1>
	 * <p>内容</p>
	 * @param sql
	 * @return
	 */
	public int gettotalpage(String sql);
	
	/**
	 * 求和
	 * @param sql
	 * @return
	 */
	public Double getSUM(String sql);


}
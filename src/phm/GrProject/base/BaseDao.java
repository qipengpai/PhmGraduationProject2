package phm.GrProject.base;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BaseDao<T> {

		@Resource
	    public SessionFactory sessionFactory;
		private Class<T> entityClass; 
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public BaseDao() {  
			  // 子类
	        Class cla = getClass();
	        // 通过子类获取到父类 
	        // 泛型参数
	        Type type = cla.getGenericSuperclass();
	        if (type instanceof ParameterizedType) {
	            ParameterizedType pType = (ParameterizedType) type;
	            entityClass = (Class<T>) pType.getActualTypeArguments()[0];
	        } 
	    }  

	    /**
	     * 保存数据
	     * 
	     * @author Xiongyan
	     * @date 2015年5月6日 下午5:24:54
	     * @throws
	     * @return void 返回类型
	     */
		@Transactional
	    public void save(T t) {
	        sessionFactory.getCurrentSession().save(t);
	    }

	    /**
	     * 删除数据
	     * 
	     * @author Xiongyan
	     * @date 2015年5月6日 下午5:26:41
	     * @throws
	     * @return void 返回类型
	     */
		@Transactional
	    public void delete(Serializable id, Class<T> clazz) {
	        T t = get(id, clazz);
	        if (t != null)
	            sessionFactory.getCurrentSession().delete(t);
	        else
	            new RuntimeException("你要删除的数据不存在").printStackTrace();
	        ;
	    }
		@Transactional
	    public void delete(T t) {
	        if (t != null)
	            sessionFactory.getCurrentSession().delete(t);
	        else
	            new RuntimeException("你要删除的数据不存在").printStackTrace();
	        ;
	    }

	    /**
	     * 更新数据
	     * 
	     * @author Xiongyan
	     * @date 2015年5月6日 下午5:29:13
	     * @throws
	     * @return void 返回类型
	     */
		@Transactional
	    public void update(T t) {
	        sessionFactory.getCurrentSession().update(t);
	    }

	    /**
	     * 根据ID查找数据
	     * 
	     * @author Xiongyan
	     * @date 2015年5月6日 下午5:29:46
	     * @throws
	     * @return T 返回类型
	     */
	    @SuppressWarnings("unchecked")
	    public T get(Serializable id, Class<T> clazz) {
	        return (T) sessionFactory.getCurrentSession().get(clazz, id);
	    }

	    /**
	     * 查找所有数据
	     * 
	     * @author Xiongyan
	     * @date 2015年5月6日 下午5:30:16
	     * @throws
	     * @return List<T> 返回类型
	     */
	    @SuppressWarnings("unchecked")
	    public List<T> getAll(Class<T> clazz) {
	        return sessionFactory.getCurrentSession().createQuery(clazz.toString()).list();
	    }
	    
	    public int gettotalpage(String sql){
	    	Query q = sessionFactory.getCurrentSession().createSQLQuery(sql);
	    	List<Object> list = q.list();
	    	int count = Integer.parseInt(list.get(0).toString());
			return count;
	    }
	    
	    public Double getSUM(String sql){
	    	Query q = sessionFactory.getCurrentSession().createSQLQuery(sql);
	    	List<Object> list = q.list();
	    	Double count =0.0;
	    	try {
	    		count=Double.parseDouble(list.get(0).toString());
	    		return count;
			} catch (Exception e) {
				return count;
			}
	    }
	    
		@SuppressWarnings("unchecked")
		@Transactional
		public List<T> SQL(String sql,Class<T> entity) {
			// TODO Auto-generated method stub
			try {
				Query q = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(entity);
				List<T> rs = q.list();
				return rs;
			} catch (Exception e) {
				// TODO: handle exception
				return new ArrayList<T>();
			}
			
			
		}

		@SuppressWarnings("unchecked")
		@Transactional
		public List<T> HQL(String hql) {
			// TODO Auto-generated method stub
			 Query query=sessionFactory.getCurrentSession().createQuery(hql);
			 List<T> list=query.list();
			return list;
		}
}

package tests.org.nanotek.musicbrainz.data.load.csv.spring.musicbrainz;

import java.util.List;
import java.util.function.Consumer;

import org.nanotek.Base;

import org.springframework.context.ApplicationContext;

public interface Insertable {

	default  <T extends Base<?>> void executeDataInsert(final List<T> baseList , ApplicationContext dataBaseContext)
	{ 
//		final DAO<T> dao = (DAO<T>) dataBaseContext.getBean("artistCreditNameDAO");
//		artistCreditNameList.parallelStream().forEach(new Consumer<T>() {
//			@Override
//			public void accept(T t) {
//				System.out.println("calling persist " + t.toString());
//				dao.persist(t);
//			}
//		});
	}
	
}

package org.nanotek.musicbrainz.job.writers.database;

import java.util.List;

import org.nanotek.Base;

import org.springframework.batch.item.ItemWriter;

public class BaseListWriter <T extends List<Base<?>>> implements ItemWriter<List<Base<?>>>{

	private DAO<Base<?>> dao;

	@Override
	public void write(List<? extends List<Base<?>>> baseLists) throws Exception {
			for (List<Base<?>> baseList : baseLists) 
			{ 
				for (Base<?> bean : baseList) { 
					dao.persist(bean);
				}
			}
	}

	public DAO<Base<?>> getDao() {
		return dao;
	}

	public void setDao(DAO<Base<?>> dao) {
		this.dao = dao;
	}

}

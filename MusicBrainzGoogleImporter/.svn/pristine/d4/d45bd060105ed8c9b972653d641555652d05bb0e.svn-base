package org.nanotek.query.event.listener;

import java.util.Iterator;
import java.util.List;

import org.nanotek.Listenable;
import org.nanotek.lucene.query.BaseQueryDispatcher;
import org.nanotek.query.ContextKeys;
import org.nanotek.query.QueryContext;
import org.nanotek.query.QueryDispatcher;
import org.nanotek.query.QueryObject;
import org.nanotek.query.QueryResult;
import org.nanotek.query.event.QueryEvent;
import org.nanotek.query.event.QueryListener;
import org.nanotek.query.event.QueryResultBase;

public class ListenableDispatcher implements QueryDispatcher<QueryContext> , Listenable<QueryListener<?>> {

	private BaseQueryDispatcher<QueryContext> queryDispatcher; 
	private List<QueryListener<?>> dispactherListeners; 
	
	public ListenableDispatcher(List<QueryListener<?>> dispactherListeners) {
		super();
		this.dispactherListeners = dispactherListeners;
	}
	
	public ListenableDispatcher(
			BaseQueryDispatcher<QueryContext> queryDispatcher,
			List<QueryListener<?>> dispactherListeners) {
		super();
		this.queryDispatcher = queryDispatcher;
		this.dispactherListeners = dispactherListeners;
	}

	@Override
	public List<QueryListener<?>> getListeners() {
		return dispactherListeners;
	}

	@Override
	public boolean add(QueryListener<?> e) {
		return dispactherListeners.add(e);
	}

	@Override
	public boolean remove(QueryListener<?> o) {
		return dispactherListeners.remove(o);
	}

	@Override
	public void dispatch(QueryObject<?> query) {
		queryDispatcher.dispatch(query);
	}

	@Override
	public void dispatch(QueryObject<?> query, QueryContext context) {
		QueryResultBase<QueryResult<?>> resultBase = new QueryResultBase<QueryResult<?>>();
		context.put(ContextKeys.HOOKED_EVENT, resultBase);
		queryDispatcher.dispatch(query, context);
		notifyEventListeners(resultBase);
	}

	@SuppressWarnings("unchecked")
	private void notifyEventListeners(QueryResultBase<QueryResult<?>> resultBase) {
			QueryEvent<QueryResult<?>> event = new QueryEvent<QueryResult<?>>(resultBase.getId());
			Iterator<QueryListener<?>> it = dispactherListeners.iterator(); 
			while(it.hasNext()) 
			{ 
				QueryListener<QueryEvent<?>> listener = (QueryListener<QueryEvent<?>>) it.next(); 
				listener.processed(event);
			}
	}

}

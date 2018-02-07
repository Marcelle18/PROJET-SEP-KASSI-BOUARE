package com.tp.interfaces;

public interface ISujetObserver {

	void attach(IObservateur obs);
	
	void detach(IObservateur obs);
}

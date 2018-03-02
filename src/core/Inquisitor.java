package core;

import request.RequestedCriterias;

/**
 * Manage the creation of SQL request from the requested criteria
 *
 */
public class Inquisitor {

	
	private Queue<RequestedCriterias> requests;
	
	/** set requestedCriterias value to the given request
	 * @param request if null this would screw up everything.
	 */
	public void addRequest(RequestedCriterias request) {
		requests.add(request);
	}

}

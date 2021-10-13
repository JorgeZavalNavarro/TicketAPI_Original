package com.ca.www.UnicenterServicePlus.ServiceDesk;

public class USD_WebServiceSoapProxy implements com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap {
  private String _endpoint = null;
  private com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap uSD_WebServiceSoap = null;
  
  public USD_WebServiceSoapProxy() {
    _initUSD_WebServiceSoapProxy();
  }
  
  public USD_WebServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initUSD_WebServiceSoapProxy();
  }
  
  private void _initUSD_WebServiceSoapProxy() {
    try {
      uSD_WebServiceSoap = (new com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceLocator()).getUSD_WebServiceSoap();
      if (uSD_WebServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)uSD_WebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)uSD_WebServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (uSD_WebServiceSoap != null)
      ((javax.xml.rpc.Stub)uSD_WebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap getUSD_WebServiceSoap() {
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap;
  }
  
  public void createObject(int sid, java.lang.String objectType, java.lang.String[] attrVals, java.lang.String[] attributes, javax.xml.rpc.holders.StringHolder createObjectResult, javax.xml.rpc.holders.StringHolder newHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.createObject(sid, objectType, attrVals, attributes, createObjectResult, newHandle);
  }
  
  public void addAssetLog(int sid, java.lang.String assetHandle, java.lang.String contactHandle, java.lang.String logText) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.addAssetLog(sid, assetHandle, contactHandle, logText);
  }
  
  public void createLrelRelationships(int sid, java.lang.String contextObject, java.lang.String lrelName, java.lang.String[] addObjectHandles) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.createLrelRelationships(sid, contextObject, lrelName, addObjectHandles);
  }
  
  public void addMemberToGroup(int sid, java.lang.String contactHandle, java.lang.String groupHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.addMemberToGroup(sid, contactHandle, groupHandle);
  }
  
  public java.lang.String attachChangeToRequest(int sid, java.lang.String creator, java.lang.String requestHandle, java.lang.String changeHandle, java.lang.String[] changeAttrVals, java.lang.String description) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.attachChangeToRequest(sid, creator, requestHandle, changeHandle, changeAttrVals, description);
  }
  
  public java.lang.String callServerMethod(int sid, java.lang.String methodName, java.lang.String factoryName, java.lang.String formatList, java.lang.String[] parameters) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.callServerMethod(sid, methodName, factoryName, formatList, parameters);
  }
  
  public java.lang.String changeStatus(int sid, java.lang.String creator, java.lang.String objectHandle, java.lang.String description, java.lang.String newStatusHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.changeStatus(sid, creator, objectHandle, description, newStatusHandle);
  }
  
  public int clearNotification(int sid, java.lang.String lrObject, java.lang.String clearBy) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.clearNotification(sid, lrObject, clearBy);
  }
  
  public java.lang.String createActivityLog(int sid, java.lang.String creator, java.lang.String objectHandle, java.lang.String description, java.lang.String logType, int timeSpent, boolean internal) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createActivityLog(sid, creator, objectHandle, description, logType, timeSpent, internal);
  }
  
  public void createAsset(int sid, java.lang.String[] attrVals, java.lang.String[] attributes, javax.xml.rpc.holders.StringHolder createAssetResult, javax.xml.rpc.holders.StringHolder newAssetHandle, javax.xml.rpc.holders.StringHolder newExtensionHandle, javax.xml.rpc.holders.StringHolder newExtensionName) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.createAsset(sid, attrVals, attributes, createAssetResult, newAssetHandle, newExtensionHandle, newExtensionName);
  }
  
  public java.lang.String createAssetParentChildRelationship(int sid, java.lang.String parentHandle, java.lang.String childHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createAssetParentChildRelationship(sid, parentHandle, childHandle);
  }
  
  public java.lang.String createAttachment(int sid, java.lang.String repositoryHandle, java.lang.String objectHandle, java.lang.String description, java.lang.String fileName) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createAttachment(sid, repositoryHandle, objectHandle, description, fileName);
  }
  
  public int removeAttachment(int sid, java.lang.String attHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.removeAttachment(sid, attHandle);
  }
  
  public java.lang.String createChangeOrder(int sid, java.lang.String creatorHandle, java.lang.String[] attrVals, java.lang.String[] propertyValues, java.lang.String template, java.lang.String[] attributes, javax.xml.rpc.holders.StringHolder newChangeHandle, javax.xml.rpc.holders.StringHolder newChangeNumber) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createChangeOrder(sid, creatorHandle, attrVals, propertyValues, template, attributes, newChangeHandle, newChangeNumber);
  }
  
  public java.lang.String createIssue(int sid, java.lang.String creatorHandle, java.lang.String[] attrVals, java.lang.String[] propertyValues, java.lang.String template, java.lang.String[] attributes, javax.xml.rpc.holders.StringHolder newIssueHandle, javax.xml.rpc.holders.StringHolder newIssueNumber) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createIssue(sid, creatorHandle, attrVals, propertyValues, template, attributes, newIssueHandle, newIssueNumber);
  }
  
  public void createWorkFlowTask(int sid, java.lang.String[] attrVals, java.lang.String objectHandle, java.lang.String creatorHandle, java.lang.String selectedWorkFlow, java.lang.String taskType, java.lang.String[] attributes, javax.xml.rpc.holders.StringHolder createWorkFlowTaskResult, javax.xml.rpc.holders.StringHolder newHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.createWorkFlowTask(sid, attrVals, objectHandle, creatorHandle, selectedWorkFlow, taskType, attributes, createWorkFlowTaskResult, newHandle);
  }
  
  public void deleteWorkFlowTask(int sid, java.lang.String workFlowHandle, java.lang.String objectHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.deleteWorkFlowTask(sid, workFlowHandle, objectHandle);
  }
  
  public java.lang.String createRequest(int sid, java.lang.String creatorHandle, java.lang.String[] attrVals, java.lang.String[] propertyValues, java.lang.String template, java.lang.String[] attributes, javax.xml.rpc.holders.StringHolder newRequestHandle, javax.xml.rpc.holders.StringHolder newRequestNumber) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createRequest(sid, creatorHandle, attrVals, propertyValues, template, attributes, newRequestHandle, newRequestNumber);
  }
  
  public java.lang.String createTicket(int sid, java.lang.String description, java.lang.String problem_type, java.lang.String userid, java.lang.String asset, java.lang.String duplication_id, javax.xml.rpc.holders.StringHolder newTicketHandle, javax.xml.rpc.holders.StringHolder newTicketNumber, javax.xml.rpc.holders.StringHolder returnUserData, javax.xml.rpc.holders.StringHolder returnApplicationData) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createTicket(sid, description, problem_type, userid, asset, duplication_id, newTicketHandle, newTicketNumber, returnUserData, returnApplicationData);
  }
  
  public java.lang.String createQuickTicket(int sid, java.lang.String customerHandle, java.lang.String description, javax.xml.rpc.holders.StringHolder newTicketHandle, javax.xml.rpc.holders.StringHolder newTicketNumber) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createQuickTicket(sid, customerHandle, description, newTicketHandle, newTicketNumber);
  }
  
  public java.lang.String closeTicket(int sid, java.lang.String description, java.lang.String ticketHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.closeTicket(sid, description, ticketHandle);
  }
  
  public void logComment(int sid, java.lang.String ticketHandle, java.lang.String comment, int internalFlag) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.logComment(sid, ticketHandle, comment, internalFlag);
  }
  
  public java.lang.String getPolicyInfo(int sid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getPolicyInfo(sid);
  }
  
  public java.lang.String detachChangeFromRequest(int sid, java.lang.String creator, java.lang.String requestHandle, java.lang.String description) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.detachChangeFromRequest(sid, creator, requestHandle, description);
  }
  
  public java.lang.String doSelect(int sid, java.lang.String objectType, java.lang.String whereClause, int maxRows, java.lang.String[] attributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.doSelect(sid, objectType, whereClause, maxRows, attributes);
  }
  
  public com.ca.www.UnicenterServicePlus.ServiceDesk.ListResult doQuery(int sid, java.lang.String objectType, java.lang.String whereClause) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.doQuery(sid, objectType, whereClause);
  }
  
  public java.lang.String escalate(int sid, java.lang.String creator, java.lang.String objectHandle, java.lang.String description, boolean setAssignee, java.lang.String newAssigneeHandle, boolean setGroup, java.lang.String newGroupHandle, boolean setOrganization, java.lang.String newOrganizationHandle, boolean setPriority, java.lang.String newPriorityHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.escalate(sid, creator, objectHandle, description, setAssignee, newAssigneeHandle, setGroup, newGroupHandle, setOrganization, newOrganizationHandle, setPriority, newPriorityHandle);
  }
  
  public void freeListHandles(int sid, int[] handles) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.freeListHandles(sid, handles);
  }
  
  public void getAssetExtensionInformation(int sid, java.lang.String assetHandle, java.lang.String[] attributes, javax.xml.rpc.holders.StringHolder getAssetExtInfoResult, javax.xml.rpc.holders.StringHolder extensionHandle, javax.xml.rpc.holders.StringHolder extensionName) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.getAssetExtensionInformation(sid, assetHandle, attributes, getAssetExtInfoResult, extensionHandle, extensionName);
  }
  
  public java.lang.String getConfigurationMode(int sid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getConfigurationMode(sid);
  }
  
  public java.lang.String getGroupMemberListValues(int sid, java.lang.String whereClause, int numToFetch, java.lang.String[] attributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getGroupMemberListValues(sid, whereClause, numToFetch, attributes);
  }
  
  public java.lang.String getObjectTypeInformation(int sid, java.lang.String factory) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getObjectTypeInformation(sid, factory);
  }
  
  public java.lang.String getHandleForUserid(int sid, java.lang.String userID) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getHandleForUserid(sid, userID);
  }
  
  public java.lang.String getAccessTypeForContact(int sid, java.lang.String contactHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getAccessTypeForContact(sid, contactHandle);
  }
  
  public java.lang.String getListValues(int sid, int listHandle, int startIndex, int endIndex, java.lang.String[] attributeNames) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getListValues(sid, listHandle, startIndex, endIndex, attributeNames);
  }
  
  public int getLrelLength(int sid, java.lang.String contextObject, java.lang.String lrelName) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getLrelLength(sid, contextObject, lrelName);
  }
  
  public java.lang.String getLrelValues(int sid, java.lang.String contextObject, java.lang.String lrelName, int startIndex, int endIndex, java.lang.String[] attributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getLrelValues(sid, contextObject, lrelName, startIndex, endIndex, attributes);
  }
  
  public com.ca.www.UnicenterServicePlus.ServiceDesk.ListResult getNotificationsForContact(int sid, java.lang.String contactHandle, int queryStatus) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getNotificationsForContact(sid, contactHandle, queryStatus);
  }
  
  public java.lang.String getObjectValues(int sid, java.lang.String objectHandle, java.lang.String[] attributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getObjectValues(sid, objectHandle, attributes);
  }
  
  public com.ca.www.UnicenterServicePlus.ServiceDesk.ListResult getPendingChangeTaskListForContact(int sid, java.lang.String contactHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getPendingChangeTaskListForContact(sid, contactHandle);
  }
  
  public com.ca.www.UnicenterServicePlus.ServiceDesk.ListResult getPendingIssueTaskListForContact(int sid, java.lang.String contactHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getPendingIssueTaskListForContact(sid, contactHandle);
  }
  
  public java.lang.String getPropertyInfoForCategory(int sid, java.lang.String categoryHandle, java.lang.String[] attributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getPropertyInfoForCategory(sid, categoryHandle, attributes);
  }
  
  public com.ca.www.UnicenterServicePlus.ServiceDesk.ListResult getRelatedList(int sid, java.lang.String objectHandle, java.lang.String listName) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getRelatedList(sid, objectHandle, listName);
  }
  
  public void getRelatedListValues(int sid, java.lang.String objectHandle, java.lang.String listName, int numToFetch, java.lang.String[] attributes, javax.xml.rpc.holders.StringHolder getRelatedListValuesResult, javax.xml.rpc.holders.IntHolder numRowsFound) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.getRelatedListValues(sid, objectHandle, listName, numToFetch, attributes, getRelatedListValuesResult, numRowsFound);
  }
  
  public java.lang.String getWorkFlowTemplates(int sid, java.lang.String objectHandle, java.lang.String[] attributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getWorkFlowTemplates(sid, objectHandle, attributes);
  }
  
  public java.lang.String getTaskListValues(int sid, java.lang.String objectHandle, java.lang.String[] attributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getTaskListValues(sid, objectHandle, attributes);
  }
  
  public java.lang.String getValidTaskTransitions(int sid, java.lang.String taskHandle, java.lang.String[] attributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getValidTaskTransitions(sid, taskHandle, attributes);
  }
  
  public java.lang.String getValidTransitions(int sid, java.lang.String handle, java.lang.String ticketFactory) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getValidTransitions(sid, handle, ticketFactory);
  }
  
  public java.lang.String getDependentAttrControls(int sid, java.lang.String handle, java.lang.String[] attrVals) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getDependentAttrControls(sid, handle, attrVals);
  }
  
  public int login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.login(username, password);
  }
  
  public int loginService(java.lang.String username, java.lang.String password, java.lang.String policy) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.loginService(username, password, policy);
  }
  
  public java.lang.String loginServiceManaged(java.lang.String policy, java.lang.String encrypted_policy) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.loginServiceManaged(policy, encrypted_policy);
  }
  
  public int loginWithArtifact(java.lang.String userid, java.lang.String artifact) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.loginWithArtifact(userid, artifact);
  }
  
  public int impersonate(int sid, java.lang.String userid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.impersonate(sid, userid);
  }
  
  public void logout(int sid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.logout(sid);
  }
  
  public java.lang.String notifyContacts(int sid, java.lang.String creator, java.lang.String contextObject, java.lang.String messageTitle, java.lang.String messageBody, int notifyLevel, java.lang.String[] notifyees, boolean internal) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.notifyContacts(sid, creator, contextObject, messageTitle, messageBody, notifyLevel, notifyees, internal);
  }
  
  public void removeLrelRelationships(int sid, java.lang.String contextObject, java.lang.String lrelName, java.lang.String[] removeObjectHandles) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.removeLrelRelationships(sid, contextObject, lrelName, removeObjectHandles);
  }
  
  public void removeMemberFromGroup(int sid, java.lang.String contactHandle, java.lang.String groupHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    uSD_WebServiceSoap.removeMemberFromGroup(sid, contactHandle, groupHandle);
  }
  
  public int serverStatus(int sid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.serverStatus(sid);
  }
  
  public java.lang.String updateObject(int sid, java.lang.String objectHandle, java.lang.String[] attrVals, java.lang.String[] attributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.updateObject(sid, objectHandle, attrVals, attributes);
  }
  
  public java.lang.String getBopsid(int sid, java.lang.String contact) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getBopsid(sid, contact);
  }
  
  public java.lang.String getArtifact(int sid, java.lang.String contact, java.lang.String passwd) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getArtifact(sid, contact, passwd);
  }
  
  public java.lang.String attachURLLinkToTicket(int sid, java.lang.String ticketHandle, java.lang.String url, java.lang.String attmntName, java.lang.String description) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.attachURLLinkToTicket(sid, ticketHandle, url, attmntName, description);
  }
  
  public java.lang.String createAttmnt(int sid, java.lang.String repositoryHandle, int folderId, int objectHandle, java.lang.String description, java.lang.String fileName) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createAttmnt(sid, repositoryHandle, folderId, objectHandle, description, fileName);
  }
  
  public java.lang.String getDocumentsByIDs(int sid, java.lang.String docIds, java.lang.String propertyList, java.lang.String sortBy, boolean descending) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getDocumentsByIDs(sid, docIds, propertyList, sortBy, descending);
  }
  
  public java.lang.String getDecisionTrees(int sid, java.lang.String propertyList, java.lang.String sortBy, boolean descending) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getDecisionTrees(sid, propertyList, sortBy, descending);
  }
  
  public int deleteDocument(int sid, int docId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.deleteDocument(sid, docId);
  }
  
  public java.lang.String getCategory(int sid, int catId, boolean getCategoryPaths) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getCategory(sid, catId, getCategoryPaths);
  }
  
  public java.lang.String getStatuses(int sid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getStatuses(sid);
  }
  
  public java.lang.String getBookmarks(int sid, java.lang.String contactId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getBookmarks(sid, contactId);
  }
  
  public java.lang.String getQuestionsAsked(int sid, int resultSize, boolean descending) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getQuestionsAsked(sid, resultSize, descending);
  }
  
  public java.lang.String getPriorities(int sid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getPriorities(sid);
  }
  
  public java.lang.String getDocumentTypes(int sid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getDocumentTypes(sid);
  }
  
  public java.lang.String getTemplateList(int sid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getTemplateList(sid);
  }
  
  public java.lang.String getWorkflowTemplateList(int sid) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getWorkflowTemplateList(sid);
  }
  
  public java.lang.String addComment(int sid, java.lang.String comment, int docId, java.lang.String email, java.lang.String username, java.lang.String contactId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.addComment(sid, comment, docId, email, username, contactId);
  }
  
  public int deleteComment(int sid, int commentId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.deleteComment(sid, commentId);
  }
  
  public java.lang.String createDocument(int sid, java.lang.String[] kdAttributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createDocument(sid, kdAttributes);
  }
  
  public java.lang.String modifyDocument(int sid, int docId, java.lang.String[] kdAttributes) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.modifyDocument(sid, docId, kdAttributes);
  }
  
  public java.lang.String rateDocument(int sid, int docId, int rating, int multiplier, java.lang.String ticketPerId, boolean onTicketAccept, boolean solveUserProblem, boolean isDefault) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.rateDocument(sid, docId, rating, multiplier, ticketPerId, onTicketAccept, solveUserProblem, isDefault);
  }
  
  public java.lang.String getComments(int sid, java.lang.String docIds) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getComments(sid, docIds);
  }
  
  public java.lang.String findContacts(int sid, java.lang.String userName, java.lang.String lastName, java.lang.String firstName, java.lang.String email, java.lang.String accessType, int inactiveFlag) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.findContacts(sid, userName, lastName, firstName, email, accessType, inactiveFlag);
  }
  
  public java.lang.String getPermissionGroups(int sid, int groupId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getPermissionGroups(sid, groupId);
  }
  
  public java.lang.String getContact(int sid, java.lang.String contactId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getContact(sid, contactId);
  }
  
  public java.lang.String addBookmark(int sid, java.lang.String contactId, int docId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.addBookmark(sid, contactId, docId);
  }
  
  public java.lang.String updateRating(int sid, int buId, int rate) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.updateRating(sid, buId, rate);
  }
  
  public java.lang.String doSelectKD(int sid, java.lang.String whereClause, java.lang.String sortBy, boolean desc, int maxRows, java.lang.String[] attributes, int skip) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.doSelectKD(sid, whereClause, sortBy, desc, maxRows, attributes, skip);
  }
  
  public java.lang.String getFolderList(int sid, int parentFolderId, int repId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getFolderList(sid, parentFolderId, repId);
  }
  
  public java.lang.String getFolderInfo(int sid, int folderId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getFolderInfo(sid, folderId);
  }
  
  public java.lang.String getAttmntList(int sid, int folderId, int repId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getAttmntList(sid, folderId, repId);
  }
  
  public java.lang.String getAttmntInfo(int sid, int attmntId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getAttmntInfo(sid, attmntId);
  }
  
  public java.lang.String getRepositoryInfo(int sid, int repositoryId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getRepositoryInfo(sid, repositoryId);
  }
  
  public java.lang.String createFolder(int sid, int parentFolderId, int repId, int folderType, java.lang.String description, java.lang.String folderName) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.createFolder(sid, parentFolderId, repId, folderType, description, folderName);
  }
  
  public java.lang.String faq(int sid, java.lang.String categoryIds, int resultSize, java.lang.String propertyList, java.lang.String sortBy, boolean descending, java.lang.String whereClause, int maxDocIDs) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.faq(sid, categoryIds, resultSize, propertyList, sortBy, descending, whereClause, maxDocIDs);
  }
  
  public int attmntFolderLinkCount(int sid, int folderId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.attmntFolderLinkCount(sid, folderId);
  }
  
  public int attachURLLink(int sid, int docId, java.lang.String url, java.lang.String attmntName, java.lang.String description) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.attachURLLink(sid, docId, url, attmntName, description);
  }
  
  public int deleteBookmark(int sid, java.lang.String contactId, int docId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.deleteBookmark(sid, contactId, docId);
  }
  
  public java.lang.String getKDListPerAttmnt(int sid, int attmntId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getKDListPerAttmnt(sid, attmntId);
  }
  
  public java.lang.String getAttmntListPerKD(int sid, int docId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getAttmntListPerKD(sid, docId);
  }
  
  public int isAttmntLinkedKD(int sid, int attmntId) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.isAttmntLinkedKD(sid, attmntId);
  }
  
  public java.lang.String transfer(int sid, java.lang.String creator, java.lang.String objectHandle, java.lang.String description, boolean setAssignee, java.lang.String newAssigneeHandle, boolean setGroup, java.lang.String newGroupHandle, boolean setOrganization, java.lang.String newOrganizationHandle) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.transfer(sid, creator, objectHandle, description, setAssignee, newAssigneeHandle, setGroup, newGroupHandle, setOrganization, newOrganizationHandle);
  }
  
  public java.lang.String search(int sid, java.lang.String problem, int resultSize, java.lang.String properties, java.lang.String sortBy, boolean descending, boolean relatedCategories, int searchType, int matchType, int searchField, java.lang.String categoryPath, java.lang.String whereClause, int maxDocIDs) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.search(sid, problem, resultSize, properties, sortBy, descending, relatedCategories, searchType, matchType, searchField, categoryPath, whereClause, maxDocIDs);
  }
  
  public java.lang.String getDocument(int sid, int docId, java.lang.String propertyList, boolean relatedDoc, boolean getAttmnt, boolean getHistory, boolean getComment, boolean getNotiList) throws java.rmi.RemoteException{
    if (uSD_WebServiceSoap == null)
      _initUSD_WebServiceSoapProxy();
    return uSD_WebServiceSoap.getDocument(sid, docId, propertyList, relatedDoc, getAttmnt, getHistory, getComment, getNotiList);
  }
  
  
}
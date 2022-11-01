/**
* <pre>
* com.pcwk.ehr.cmn
* Class Name : WorkDiv.java
* Description: Data Access Object ǥ�� Interface
* Author: ITSC
* Since: 2022/09/26
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* ������   ������    ��������
*-----------------------------------------------------
*2022/09/26 ���ʻ���
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ehr.cmn;

import java.util.List;

/**
 * DAO ǥ��ȭ interface
 * @author ITSC
 *
 */
public interface WorkDiv<T> {
	/**
	 * �����ȸ
	 * @param dto
	 * @return List<DTO>
	 */
	public abstract List<T> doRetrieve(DTO dto);

	/**
	 * ���
	 * @param DTO
	 * @return 1(����)/0(����)
	 */
	public abstract int doSave(T dto);


	/**
	 * ����
	 * @param DTO
	 * @return 1(����)/0(����)
	 */
	public int doUpdate(T dto);
	
	/**
	 * ����
	 * @param DTO
	 * @return 1(����)/0(����)
	 */
	int doDelete(T dto);
	

	//�ܰ���ȸ
	/**
	 * �ܰ���ȸ 
	 * @param DTO
	 * @return DTO
	 */
	T doSelectOne(T obj);
	
}

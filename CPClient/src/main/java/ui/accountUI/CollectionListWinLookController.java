package ui.accountUI;

import VO.accountVO.CollectionListVO;
import VO.accountVO.TransferItemVO;

public class CollectionListWinLookController extends CollectionListWinController{
	private CollectionListVO collectionListVO;

	public void init(){
		VIPName.setText(collectionListVO.getVIPName());
		VIPID.setText(collectionListVO.getVIPID());
		operator.setText(collectionListVO.getOperator());
		listID.setText(collectionListVO.getId());
		totalAmount.setText(String.valueOf(collectionListVO.getTotalAmount()));
		for(TransferItemVO item : collectionListVO.getTransferItem()){
			transferItem.add(new TransferItem(item));
		}
		super.init();
		TransferListTableView.setEditable(false);
		AccountComboBox.setVisible(false);
		accountLabel.setVisible(false);
		commitBtn.setText("关闭");
		saveBtn.setVisible(false);
		selectVIPBtn.setVisible(false);
		
	}

	public void setCollectionListVO(CollectionListVO collectionListVO) {
		this.collectionListVO = collectionListVO;
	}
	
	
	
}

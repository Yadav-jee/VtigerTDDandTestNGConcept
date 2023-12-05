package com.evs.Vtiger.Pages.Inventory.Invoice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.Vtiger.ObjectRepository.InventoryInvoicelanding_OR;
import com.evs.Vtiger.Utils.WebUtil;

public class InventoryInvoiceLandingpage extends InventoryInvoicelanding_OR {
	private WebUtil wt;

	public InventoryInvoiceLandingpage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void ClickOncreatenewInvoicbutton() {
		wt.Click(getCreateInvoiceButton());

	}
}

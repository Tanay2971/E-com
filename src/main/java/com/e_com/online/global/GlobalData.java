package com.e_com.online.global;

import java.util.ArrayList;
import java.util.List;

import com.e_com.online.model.Product;

public class GlobalData {
	public static List<Product> cart;
	static {
		cart= new ArrayList<Product>();
	}

}

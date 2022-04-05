#pragma once
using namespace System;

ref class Product
{
private:
	String ^ name;
	double price;
public:
	Product();
	Product(String^ n, double p);
	~Product();
	void set_name(String^ n);
	void set_price(double p);
	String^ get_name();
	double get_price();
};


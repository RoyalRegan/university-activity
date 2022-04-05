#include "Product.h"



Product::Product()
{

}

Product::~Product()
{

}

Product::Product(String^ n, double p)
{
	name = n;
	price = p;
}

void Product::set_name(String^ n)
{
	name = n;
}

void Product::set_price(double p)
{
	price = p;
}

String^ Product::get_name()
{
	return name;
}

double Product::get_price()
{
	return price;
}

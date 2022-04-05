#include "Basket.h"



Basket::Basket() :Store()
{

}

Basket::~Basket()
{

}

void Basket::rem_product(String ^ n)
{
	for (int i = 0; i < products.size(); i++)
	{
		if (products[i]->get_name() == n)
		{
			products.erase(products.begin() + i);
			break;
		}
	}
}

double Basket::get_full_price()
{
	double full_price = 0;
	for (int i = 0; i < products.size(); i++)
	{
		full_price += products[i]->get_price();
	}
	return full_price;
}

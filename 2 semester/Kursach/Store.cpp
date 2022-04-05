#include "Store.h"

Store::Store()
{

}

Store::~Store()
{

}

void Store::add_product(Product^ t)
{
	products.push_back(t);
}

vector<Product^>Store::get_product()
{
	return products;
}

Product ^ Store::search_product(String ^ n)
{
	for (int i = 0; i < products.size(); i++)
	{
		if (products[i]->get_name() == n)
		{
			return products[i];
		}
	}
}


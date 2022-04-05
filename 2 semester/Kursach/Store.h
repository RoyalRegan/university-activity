#pragma once
#include <cliext/vector>
#include "Product.h"
using namespace cliext;

ref class Store
{
protected:
	vector<Product^> products;
public:
	Store();
	~Store();
	void add_product(Product^ t);
	Product^ search_product(String ^ n);
	vector<Product^> get_product();
};

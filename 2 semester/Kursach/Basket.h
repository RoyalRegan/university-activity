#pragma once
#include "Store.h"

ref class Basket : public Store
{
public:
	Basket();
	~Basket();
	void rem_product(String ^n);
	double get_full_price();
};

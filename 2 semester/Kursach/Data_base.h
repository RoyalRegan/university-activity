#pragma once
#include "Bank.h"
#include "Basket.h"

ref class Data_base
{
public:
	static Bank ^ clients = gcnew Bank;
	static Bank_Acc^ client = gcnew Bank_Acc;
	static Bank_Acc_Kart^ client_karta = gcnew Bank_Acc_Kart;
	static Store^ products = gcnew Store();
	static Basket ^ korzin = gcnew Basket();
};


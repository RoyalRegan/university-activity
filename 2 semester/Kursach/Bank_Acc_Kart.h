#pragma once
#include"Bank_Acc.h"

ref class Bank_Acc_Kart : public Bank_Acc
{
private:
	String ^ code;
	int CV2;
	String^ PIN;
	int month;
	int year;
	bool block;
public:
	Bank_Acc_Kart();
	Bank_Acc_Kart(String^ l, String^ p, String^ s, String^ f, String^ pat, double m, String^ pin, String^ b);
	~Bank_Acc_Kart();
	void set_code();
	void set_CV2();
	void set_PIN(String^ p);
	void set_srok_deistvia();
	void set_block(bool b);
	String^ get_code();
	int get_CV2();
	String^ get_PIN();
	int get_month();
	int get_year();
	bool get_block();
	void add_kart(Bank_Acc^ b, String^ p);
};


#include "Bank_Acc_Kart.h"
#include <ctime>

Bank_Acc_Kart::Bank_Acc_Kart() : Bank_Acc()
{
	code = "";
	CV2 = NULL;
	PIN = "";
	month = NULL;
	year = NULL;
	block = false;

}

Bank_Acc_Kart::Bank_Acc_Kart(String^ l, String^ p, String^ s, String^ f, String^ pat, double m, String^ pin, String^ b) : Bank_Acc(l, p, s, f, pat, m)
{
	PIN = pin;
	if (b == "true")
	{
		block = true;
	}
	if (b == "false")
	{
		block = false;
	}
}

Bank_Acc_Kart::~Bank_Acc_Kart()
{

}

void Bank_Acc_Kart::set_code()
{
	code = "";
	for (int i = 0; i < 16; i++)
	{
		code += (rand() % 10).ToString();
	}
}

void Bank_Acc_Kart::set_CV2()
{
	CV2 = rand() % 899 + 100;
}

void Bank_Acc_Kart::set_PIN(String^ p)
{
	PIN = p;
}

void Bank_Acc_Kart::set_srok_deistvia()
{

	month = rand() % 12 + 1;
	year = rand() % 5 + 2018;
}

void Bank_Acc_Kart::set_block(bool b)
{
	block = b;
}


String^ Bank_Acc_Kart::get_code()
{
	return code;
}

int Bank_Acc_Kart::get_CV2()
{
	return CV2;
}

String^ Bank_Acc_Kart::get_PIN()
{
	return PIN;
}

int Bank_Acc_Kart::get_month()
{
	return month;
}

int Bank_Acc_Kart::get_year()
{
	return year;
}

bool Bank_Acc_Kart::get_block()
{
	return block;
}

void Bank_Acc_Kart::add_kart(Bank_Acc^ b, String^ p)
{
	login = b->get_login();
	password = b->get_passwotd();
	secondName = b->get_secondName();
	firstName = b->get_firstName();
	patronymic = b->get_patronymic();
	person_acc = b->get_person_acc();
	money = b->get_money();
	transactions = b->get_transactions();
	this->set_code();
	this->set_CV2();
	this->set_PIN(p);
	this->set_srok_deistvia();
	block = false;
}
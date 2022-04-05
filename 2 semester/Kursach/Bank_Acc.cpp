#include "Bank_Acc.h"
#include <ctime>


Bank_Acc::Bank_Acc()
{
	srand(time(NULL));
	login = "";
	password = "";
	secondName = "";
	firstName = "";
	patronymic = "";
	person_acc = "";
	money = NULL;
}

Bank_Acc::Bank_Acc(String^ l, String^ p, String^ s, String^ f, String^ pat, double m)
{
	login = l;
	password = p;
	secondName = s;
	firstName = f;
	patronymic = pat;
	money = m;
}

Bank_Acc::~Bank_Acc()
{

}

void Bank_Acc::set_login(String^ l)
{
	login = l;
}

void Bank_Acc::set_password(String^ p)
{
	password = p;
}

void Bank_Acc::set_secondName(String^ s)
{
	secondName = s;
}

void Bank_Acc::set_firstName(String^ f)
{
	firstName = f;
}

void Bank_Acc::set_patronymic(String^ p)
{
	patronymic = p;
}

void Bank_Acc::set_person_acc()
{
	person_acc = "4080281006458";
	for (int i = 0; i < 7; i++)
	{
		person_acc += (rand() % 10).ToString();
	}
}

void Bank_Acc::set_money(double m)
{
	money = m;
}

void Bank_Acc::set_transactions()
{
	int n = rand() % 15 + 3;
	double p;
	for (int i = 0; i < n; i++)
	{
		transaction += rand() % 999;
		p = -5000 + rand() % 10000;
		transactions[transaction] = p;
	}
}

String^ Bank_Acc::get_login()
{
	return login;
}

String^ Bank_Acc::get_passwotd()
{
	return password;
}


String^ Bank_Acc::get_secondName()
{
	return secondName;
}

String^ Bank_Acc::get_firstName()
{
	return firstName;
}

String^ Bank_Acc::get_patronymic()
{
	return patronymic;
}

String^ Bank_Acc::get_person_acc()
{
	return person_acc;
}

double Bank_Acc::get_money()
{
	return money;
}

map <int, double> Bank_Acc::get_transactions()
{
	return transactions;
}

void Bank_Acc::payment(double o)
{
	money -= o;
}

void Bank_Acc::restock(double p)
{
	money += p;
}

void Bank_Acc::add_transaction(double m)
{
	transaction += rand() % 999;
	transactions[transaction] = m;
}

bool Bank_Acc::is_empty()
{
	if (login == "")
	{
		return true;
	}
	return false;
}

#include "Bank.h"

Bank::Bank()
{

}

Bank::~Bank()
{

}

void Bank::add_acc(Bank_Acc^ c)
{
	acc.push_back(c);
}

void Bank::add_acc_kart(Bank_Acc_Kart^ k)
{
	acc_kart.push_back(k);
}

vector <Bank_Acc^> Bank::get_acc()
{
	return acc;
}

vector <Bank_Acc_Kart^> Bank::get_acc_kart()
{
	return acc_kart;
}

void Bank::del_acc(Bank_Acc^ c)
{
	for (int i = 0; i < acc.size(); i++)
	{
		if (acc[i]->get_person_acc() == c->get_person_acc())
		{
			acc.erase(acc.begin() + i);
		}
	}
}

void Bank::del_acc_kart(Bank_Acc_Kart^ k)
{
	for (int i = 0; i < acc_kart.size(); i++)
	{
		if (acc_kart[i]->get_person_acc() == k->get_person_acc())
		{
			acc_kart.erase(acc_kart.begin() + i);
		}
	}
}

Bank_Acc^ Bank::search_acc_person_acc(String^ s)
{
	for (int i = 0; i < acc.size(); i++)
	{
		if (acc[i]->get_person_acc() == s)
		{
			return acc[i];
		}
	}
}

Bank_Acc_Kart^ Bank::search_acc_kart_person_acc(String^ s)
{
	for (int i = 0; i < acc_kart.size(); i++)
	{
		if (acc_kart[i]->get_person_acc() == s)
		{
			return acc_kart[i];
		}
	}
}

Bank_Acc^ Bank::search_acc_login_password(String^ l, String^ p)
{
	for (int i = 0; i < acc.size(); i++)
	{
		if (acc[i]->get_login() == l && acc[i]->get_passwotd() == p)
		{
			return acc[i];
		}
	}
}
Bank_Acc_Kart^ Bank::search_acc_kart_login_password(String^ l, String^ p)
{
	for (int i = 0; i < acc_kart.size(); i++)
	{
		if (acc_kart[i]->get_login() == l && acc_kart[i]->get_passwotd() == p)
		{
			return acc_kart[i];
		}
	}
}

bool Bank::chek_acc_login(String^ l)
{
	for (int i = 0; i < acc.size(); i++)
	{
		if (acc[i]->get_login() == l)
		{
			return true;
		}
	}
	return false;
}

bool Bank::chek_acc_kart_login(String^ l)
{
	for (int i = 0; i < acc_kart.size(); i++)
	{
		if (acc_kart[i]->get_login() == l)
		{
			return true;
		}
	}
	return false;
}

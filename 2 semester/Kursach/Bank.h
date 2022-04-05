#pragma once
#include "Bank_Acc_Kart.h"
#include <cliext/vector>

ref class Bank
{
private:
	vector <Bank_Acc^> acc;
	vector <Bank_Acc_Kart^> acc_kart;
public:
	Bank();
	~Bank();
	void add_acc(Bank_Acc^ c);
	void add_acc_kart(Bank_Acc_Kart^ k);
	void del_acc(Bank_Acc^ c);
	void del_acc_kart(Bank_Acc_Kart^ k);
	Bank_Acc^ search_acc_person_acc(String^ s);
	Bank_Acc_Kart^ search_acc_kart_person_acc(String^ s);
	Bank_Acc^ search_acc_login_password(String^ l, String^ p);
	Bank_Acc_Kart^ search_acc_kart_login_password(String^ l, String^ p);
	bool chek_acc_login(String^ l);
	bool chek_acc_kart_login(String^ l);
	vector <Bank_Acc^> get_acc();
	vector <Bank_Acc_Kart^> get_acc_kart();
};

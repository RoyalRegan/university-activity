#pragma once
#include <cliext/map>
using namespace System;
using namespace cliext;

ref class Bank_Acc
{
protected:
	String ^ login;
	String^  password;
	String ^ secondName;
	String^ firstName;
	String^ patronymic;
	String^  person_acc;
	double money;
	static int transaction = 1000000;
	map <int, double> transactions;
public:
	Bank_Acc();
	Bank_Acc(String^ l, String^ p, String^ s, String^ f, String^ pat,double m);
	~Bank_Acc();
	void set_login(String^ l);
	void set_password(String^ p);
	void set_secondName(String^ s);
	void set_firstName(String^ f);
	void set_patronymic(String^ p);
	void set_person_acc();
	void set_money(double m);
	void set_transactions();
	String^ get_login();
	String^ get_passwotd();
	String^ get_secondName();
	String^ get_firstName();
	String^ get_patronymic();
	String^ get_person_acc();
	map<int, double> get_transactions();
	void add_transaction(double m);
	double get_money();
	void payment(double o);
	void restock(double p);
	bool is_empty();
};



// Лаба-5.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include "sportsmen_strani.h"

void sportsmen::info(string a, string& k, float& w, float& g)
{
	if (a == SecondName)
	{
		k = KindOfSport;
		w = Weight;
		g = Growth;
	}
}
void sportsmen::vivodinfo(string k, float w, float g)
{
	if (k != "")
	{
		cout <<"Спортсмен: "<<SecondName<<endl;
		cout << k<<endl;
		cout << w<<endl;
		cout << g<<endl;
		cout << endl;
	}
	else
	{
		cout << "Информации нет"<<endl;
	}
}
void sportsmen::dva_sport(string a, string b)
{
	if (a == b)
	{
		cout << "Спортсмены занимаются одним и тем же видом спорта"<<endl;
		cout << endl;
	}
	else
	{
		cout << "Спортсмены не занимаются одним и тем же видом спорта"<<endl;
		cout << endl;
	}
}

void sportsmen_strani::info_strani(string a, string b, string& t, string& t1)
{
	if (a == sportsmen::get_SecondName()&&b==sportsmen::get_FirstName())
	{
		t = TrenertSecondName;
		t1 = TrenertFirstName;
	}
}

void sportsmen_strani::vivodinfo_strani(string t, string t1)
{
	if (t != "")
	{
		cout << "Тренер" << endl;
		cout << t<<endl;
		cout << t1<<endl;
		cout << endl;
	}
	else
	{
		cout << "Информации нет" << endl;
		cout << endl;
	}
}

void sportsmen_strani::dva_sport_strani(string a, string b)
{
	if (a == b)
	{
		cout << "Спортсмены из одной страны"<<endl;
		cout << endl;
	}
	else
	{
		cout << "Спортсмены не из одной страны" << endl;
		cout << endl;
	}
}


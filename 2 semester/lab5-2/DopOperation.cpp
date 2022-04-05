#include "stdafx.h"
#include "sportsmen_strani.h"

void sportsmen::info(vector<sportsmen> sportsmens,string& k, float& w, float& g)
{
	string s;
	cout << "������� ������� ����������" << endl;
	cin >> s;
	for (unsigned int i = 0; i < sportsmens.size(); i++)
	{
		if (sportsmens[i].get_SecondName() == s)
		{
			k = sportsmens[i].get_KindOfSport();
			w = sportsmens[i].get_Weight();
			g = sportsmens[i].get_Growth();
			cout << "�����, ���, ����" << endl << k << endl << w << endl << g << endl;
			return;
		}
	}
	cout << "����� ������� ���" << endl;
}

void sportsmen::dva_sport(vector<sportsmen> sportsmens)
{
	if (sportsmens.size() > 1)
	{
		unsigned int a, b;
		cout << "����� " << sportsmens.size() << " �����������" << endl;
		cout << "������� ������ �����������" << endl;
		cin >> a >> b;
		a -= 1;b -= 1;
		while (a > sportsmens.size() || b > sportsmens.size())
		{
			cout << "����� " << sportsmens.size() << " �����������" << endl;
			cout << "������� ������ �����������" << endl;
			cin >> a >> b;
			a -= 1; b -= 1;
		}
		if (sportsmens[a].get_KindOfSport() == sportsmens[b].get_KindOfSport())
		{
			cout << "���������� ���������� ����� ����� ������" << endl;
		}
		else
		{
			cout << "���������� �� ���������� ����� ����� ������" << endl;
		}
	}
	else
	{
		cout << "������� ������ �����������" << endl;
	}
}

void sportsmen_strani::info_strani(vector<sportsmen_strani> sportsmens_strani, string& t, string& t1)
{
	string s;
	string s1;
	cout << "������� �������" << endl;
	cin >> s;
	cout << "������� ���" << endl;
	cin >> s1;
	for (unsigned int i = 0; i < sportsmens_strani.size(); i++)
	{
		if (sportsmens_strani[i].get_SecondName() == s && sportsmens_strani[i].get_FirstName() == s1)
		{
			t=sportsmens_strani[i].get_TrenertSecondName();
			t1=sportsmens_strani[i].get_TrenertFirstName();
			cout << "������" << endl<< t << endl << t1 << endl;
			
			return;
		}
	}
	cout << "����� ������� ��� ����� ���" << endl;
}

void sportsmen_strani::dva_sport(vector<sportsmen_strani> sportsmens_strani)
{
	if (sportsmens_strani.size() > 1)
	{
		for (unsigned int i = 0; i < sportsmens_strani.size(); i++)
		{
			for (unsigned int j = i; j < sportsmens_strani.size(); j++)
			{
				if (i != j)
				{
					if (sportsmens_strani[i].get_Strana() == sportsmens_strani[j].get_Strana())
					{
						cout << sportsmens_strani[i].get_SecondName() << " � " << sportsmens_strani[j].get_SecondName()<<" �� ����� ������" << endl;
					}
				}
			}
		}
	}
	else
	{
		cout << "������� ������ �����������" << endl;
	}
}
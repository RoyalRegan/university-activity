#include "stdafx.h"
#include "Mnogochlen.h"
#include <iostream>
#include <string>
#include <math.h>

Mnogochlen::Mnogochlen()
{

}

Mnogochlen::Mnogochlen(vector<double> mnogochlen)
{
	Mnog = mnogochlen;
}

Mnogochlen::~Mnogochlen()
{

}

bool proverka()
{
	cin.clear();
	string s;
	getline(cin, s, '\n');
	for (auto x : s)
	{
		if (x<'0' || x>'9')
		{
			cin.clear();
			return false;
		}
	}
	return true;
}

void Mnogochlen::set_mnogochlen()
{
	int n;
	int c=0;
	cout << "������� ���-�� X" << endl;
	cin >> n;
	while (!proverka() || n < 1)
	{
		cout << "������� ���������� ��� - �� X" << endl;
		cin >> n;
	}
	while(n!=0)
	{
		double k;
		int s;
		cout << "������� �������� X" <<c<< endl;
		cin >> k;
		while (!proverka())
		{
			cout << "������� ���������� ��������" << endl;
			cin >> k;
		}
		cout << "������� ������� X" << c << endl;
		cin >> s;
		while (!proverka())
		{
			cout << "������� ���������� �������" << endl;
			cin >> s;
		}
		Mnog.push_back(k); Mnog.push_back(s);
		n--;
		c++;
	}	
}

vector<double> Mnogochlen::get_mnogochlen()
{
	return Mnog;
}

double Mnogochlen::znach()
{
	double x;
	double znach=0;
	cout << "X �����: ";
	cin >> x;
	while (!proverka())
	{
		cout << "������� ���������� X" << endl;
		cin >> x;
	}
	for (unsigned int i = 0; i < Mnog.size() - 1; i++)
	{
		znach += Mnog[i] * pow(x, Mnog[i + 1]);
		i++;
	}
	return znach;
}

void Mnogochlen::podob()
{
	vector <double>a;
	int k=0;
	string s;
	bool c = true;
	for (unsigned int i = 0; i < Mnog.size(); i++)
	{
		if (i % 2 != 0)
		{
			a.push_back(Mnog[i]);
			k = Mnog[i];
			for (unsigned int j = i; j < Mnog.size(); j++)
			{
				if (j != i && j % 2 != 0 && Mnog[j] == k)
				{
					cout << Mnog[i - 1] << "x" << "^" << Mnog[i] << " � " << Mnog[j - 1] << "x" << "^" << Mnog[j] << " �������" << endl;
				}
			}
		}
	}
	
}

ostream &operator <<(ostream &os, Mnogochlen mnog)
{
	for (unsigned int i = 0; i < mnog.get_mnogochlen().size() - 1; i++)
	{
		os << "(" << mnog.get_mnogochlen()[i] << ")" << "x" << "^" << "(" << mnog.get_mnogochlen()[i + 1] << ")";
		if (i != mnog.get_mnogochlen().size() - 2)
		{
			os << "+";
		}
		i++;
	}
	os << endl;
	return os;
}

void Mnogochlen::operator -()
{
	for (unsigned int i = 0; i < Mnog.size(); i++)
	{
		if (i % 2 != 0)
		{
			Mnog[i - 1] *= Mnog[i];
			Mnog[i] -= 1;
		}
	}
}

void Mnogochlen::operator<(Mnogochlen mnog)
{
	double znach1, znach2;
	cout << "��������� 1 : "; cout << *this;
	cout << "��������� 2 : "; cout << mnog;
	cout << endl;
	if ((znach1=this->znach()) < (znach2=mnog.znach()))
	{
		cout << endl;
		cout << "�������� 1 ����������: " << znach1<<endl;
		cout << "�������� 2 ����������: " << znach2<<endl;
		cout << endl;
		cout << "1-�� ������ 2-���" << endl;
	}
	else
	{
		cout << endl;
		cout << "�������� 1 ����������: " << znach1<<endl;
		cout << "�������� 2 ����������: " << znach2<<endl;
		cout << endl;
		cout << "1-�� ������ 2-���" << endl;
	}
}
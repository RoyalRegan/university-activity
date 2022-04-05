#pragma once

#include <iostream>
#include <string>
#include <vector>
#include "Unit_Def.h"

using namespace std;

void Zapln(SportsmenInfo &a)
{
	cout << "������� ������� ����������" << endl;
	cin >> a.SecondName;
	cout << "������� ��� ����������" << endl;
	cin >> a.FisrtName;
	cout << "������� ���� �������� ����������(����,�����,���)" << endl;
	cin >> a.data.day;
	while (a.data.day > 31 || a.data.day < 1)
	{
		cout << "������� ���������� ����" << endl;
		cin >> a.data.day;
	}
	cin >> a.data.month;
	while (a.data.month > 12 || a.data.month < 1)
	{
		cout << "������� ���������� �����" << endl;
		cin >> a.data.month;
	}
	cin >> a.data.year;
	while (a.data.year > 2018 || a.data.year < 0)
	{
		cout << "������� ���������� �����" << endl;
		cin >> a.data.year;
	}
	cout << "������� ��� ����������(��)" << endl;
	cin >> a.Weight;
	cout << "������� ���� ����������(�)" << endl;
	cin >> a.Growth;
	cout << "������� ��� ����������" << endl;
	cin >> a.Sex;
	while (a.Sex != "M" && a.Sex != "W" && a.Sex != "�" && a.Sex != "�")
	{
		cout << "������� ���������� ���" << endl;
		cin >> a.Sex;
	}
}

void Vivod(SportsmenInfo a)
{
	cout << "������ ����������" << endl << endl;
	if (a.SecondName != "")
	{
		cout << "�������: " << a.SecondName << endl;
		cout << "���: " << a.FisrtName << endl;
		cout << "���� ��������: " << a.data.day << "." << a.data.month << "." << a.data.year << endl;
		cout << "���: " << a.Weight << " ��" << endl;
		cout << "����:" << a.Growth << " �" << endl;
		cout << "���: " << a.Sex << endl;
	}
	else
	{
		cout << "�������� ����������" << endl;
	}
}

void ZaplnList(vector<SportsmenInfo> &a, SportsmenInfo b)
{
	if (b.SecondName != "")
	{
		a.push_back(b);
	}
	else
	{
		cout << "�������� ����������" << endl;
	}
}

void VivodList(vector<SportsmenInfo> a)
{
	cout << "������ �����������" << endl << endl;
	if (a.size() > 0)
	{
		for (unsigned int i = 0; i < a.size(); i++)
		{
			cout << "�������: " << a[i].SecondName << endl;
			cout << "���: " << a[i].FisrtName << endl;
			cout << "���� ��������: " << a[i].data.day << "." << a[i].data.month << "." << a[i].data.year << endl;
			cout << "���: " << a[i].Weight << endl;
			cout << "����:" << a[i].Growth << endl;
			cout << "���: " << a[i].Sex << endl;
			cout << endl << endl;
		}
	}
	else
	{
		cout << "����� ���" << endl;
	}
}
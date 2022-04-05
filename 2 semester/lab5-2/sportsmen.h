#pragma once
#ifndef SPORTSMEN_H
#define SPORTSMEN_H

#include "stdafx.h"
#include <string>
#include <vector>
#include <iostream>
using namespace std;

struct BornData
{
	int day;
	int month;
	int year;
};

class sportsmen
{
private:
	string SecondName;
	string FirstName;
	BornData Data;
	float Weight;
	float Growth;
	string Sex;
	string KindOfSport;
public:
	sportsmen()
	{
		SecondName = "";
		FirstName = "";
		Data.day = NULL;
		Data.month = NULL;
		Data.year = NULL;
		Weight = NULL;
		Growth = NULL;
		Sex = "";
		KindOfSport = "";
	}
	sportsmen(string s, string f, int d, int m, int y, float w, float g, string S, string k)
	{
		SecondName = s;
		FirstName = f;
		Data.day = d;
		Data.month = m;
		Data.year = y;
		Weight = w;
		Growth = g;
		Sex = S;
		KindOfSport = k;
	}
	// заполнение полей 
	void set_SecondName(string s)
	{
		SecondName = s;
	}
	void set_FisrtName(string f)
	{
		FirstName = f;
	}
	void set_Data(int d, int m, int y)
	{
		Data.day = d;
		Data.month = m;
		Data.year = y;
	}
	void set_Weight(float w)
	{
		Weight = w;
	}
	void set_Growth(float g)
	{
		Growth = g;
	}
	void set_Sex(string S)
	{
		Sex = S;
	}
	void set_KindOfSport(string k)
	{
		KindOfSport = k;
	}
	// вывод содержания полей
	string get_SecondName()
	{
		return SecondName;
	}
	string get_FirstName()
	{
		return FirstName;
	}
	int get_Data_day()
	{
		return Data.day;
	}
	int get_Data_month()
	{
		return Data.month;
	}
	int get_Data_year()
	{
		return Data.year;
	}
	float get_Weight()
	{
		return Weight;
	}
	float get_Growth()
	{
		return Growth;
	}
	string get_Sex()
	{
		return Sex;
	}
	string get_KindOfSport()
	{
		return KindOfSport;
	}
	~sportsmen()
	{
		cout << "Deleted" << endl;
	}
	void info(vector<sportsmen> sportsmens,string& k, float& w, float& g); // доп метод 1
	void dva_sport(vector<sportsmen> sportsmens); // доп метод 2
};
#endif SPORTSMEN_H

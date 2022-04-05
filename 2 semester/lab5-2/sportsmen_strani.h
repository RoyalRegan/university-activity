#pragma once
#ifndef SPORTSMEN_STRANI_H
#define SPORTSMEN_STRANI_H

#include "sportsmen.h"

class sportsmen_strani :public sportsmen
{
private:
	string Strana;
	string TrenertSecondName;
	string TrenertFirstName;
public:

	sportsmen_strani(string s, string f, int d, int m, int y, float w, float g, string S, string k) :sportsmen(s, f, d, m, y, w, g, S, k)
	{
		Strana = "";
		TrenertSecondName = "";
		TrenertFirstName = "";
	}
	sportsmen_strani() :sportsmen()
	{
		Strana = "";
		TrenertSecondName = "";
		TrenertFirstName = "";
	}
	// заполнение полей наследника
	void set_Strana(string s1)
	{
		Strana = s1;
	}
	void set_TrenertSecondName(string t)
	{
		TrenertSecondName = t;
	}
	void set_TrenertFirstName(string t1)
	{
		TrenertFirstName = t1;
	}
	// вывод полей наследника 
	string get_Strana()
	{
		return Strana;
	}
	string get_TrenertSecondName()
	{
		return TrenertSecondName;
	}
	string get_TrenertFirstName()
	{
		return TrenertFirstName;
	}
	void info_strani(vector<sportsmen_strani> sportsmens_strani, string& t, string& t1); // доп метод 1 наслденика 
	void dva_sport(vector<sportsmen_strani> sportsmens_strani); // доп метод 2 наследника 

};
#endif SPORTSMEN_STRANI_H
#ifndef Unit_Def_H
#define Unit_Def_H
using namespace std;
#include<string>
#include <vector>


struct BornData
{
	int day;
	int month;
	int year;
};


struct SportsmenInfo
{
	string SecondName;
	string FisrtName;
	BornData data;
	float Weight;
	float Growth;
	string Sex;
};

SportsmenInfo Sportsmen;
//vector<SportsmenInfo> Sportsmens;
//vector<SportsmenInfo> NewSportsmensList;

#endif Unit_Def_H
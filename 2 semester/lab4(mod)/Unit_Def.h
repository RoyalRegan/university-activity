#pragma once

#include<string>
#include <vector>
using namespace std;

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
vector<SportsmenInfo> Sportsmens;
vector<SportsmenInfo> NewSportsmensList;

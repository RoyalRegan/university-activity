#pragma once
#include <cliext/vector>
using namespace System;
using namespace cliext;

ref struct BornData
{
	int day;
	int month;
	int year;
};

ref struct SportsmenInfo
{
	String ^ SecondName;
	String ^ FisrtName;
	BornData^ data = gcnew BornData;
	float Weight;
	float Growth;
	String ^ Sex;
};

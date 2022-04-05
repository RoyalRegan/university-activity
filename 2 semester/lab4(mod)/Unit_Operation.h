#pragma once

#include <iostream>
#include <string>
#include <vector>
#include "Unit_Def.h"

using namespace std;

void Sortirovka(vector<SportsmenInfo> &a)
{
	if (a.size() > 1)
	{
		for (unsigned int i = 0; i < a.size() - 1; i++)
		{
			for (unsigned int j = 0; j<a.size() - i - 1; j++)
			{
				if (a[j].Weight < a[j + 1].Weight)
				{
					swap(a[j], a[j + 1]);
				}
			}
		}
	}
	else
	{
		cout << "Добавьте больше анкет" << endl;
	}
}

bool Proverka(BornData a)
{
	if ((a.year >= 1997 && a.month <= 12 && a.day <= 30) || (a.year>1997))
	{
		return true;
	}
	return false;
}

void NewList(vector<SportsmenInfo>a, vector<SportsmenInfo>&b)
{
	for (unsigned int i = 0; i < a.size(); i++)
	{
		if ((a[i].Sex == "M" || a[i].Sex == "М") && (Proverka(a[i].data)))
		{
			b.push_back(a[i]);
		}
	}
}
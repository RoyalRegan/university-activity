#pragma once
#ifndef MENU_H
#define MENU_H

#include "stdafx.h"
#include"sportsmen_strani.h"
using namespace std;

class menu
{
public:
	menu();
	~menu();
	void show_menu();
	void vvod_dannix(sportsmen &sport);
	void vivod_dannix(sportsmen sport);
	void vvod_dannix_strani(sportsmen_strani &sport_strani);
	void vivod_dannix_strani(sportsmen_strani sport_strani);
private:
	sportsmen pervi_sportsmen;
	sportsmen_strani pervi_sportsmen_strani;
	int vibor;
	string vidspr = "",trenername="",trenersecondname="";
	float ves, rost;
};
#endif MENU_H
#pragma once
#ifndef MENU_H
#define MENU_H

#include"sportsmen_strani.h" 
#include <Windows.h>

class menu
{
public:
	menu(); // ����� ������ ����� � ������ �� ������� 
	~menu();
	void show_menu(); // ������ ����
	bool proverka_1(string s); // �������� �� ���� ����
	bool proverka_2(); // �������� �� ���� �����(int)
	bool proverka_3(float &a); // �������� �� ���� �����(float)
	void vvod_dannix(sportsmen &sport); // ���������� ���������� � ����������
	static void vivod_dannix(sportsmen sport); // ����� ���������� � ����������
	void add_dannie(vector<sportsmen> &sportsmens, sportsmen sport); // ���������� ���������� � ������ 
	void list_dannie(vector<sportsmen> sportsmens); // ����� ������ ����������
	void vvod_dannix_strani(sportsmen_strani &sport_strani); // ���������� ���������� � ����������_������
	static void vivod_dannix_strani(sportsmen_strani sport_strani); // ����� ���������� � ����������_������
	void add_dannie_strani(vector<sportsmen_strani> &sportsmens_strani, sportsmen_strani sport_strani); // ���������� ����������_������ � ������ 
	void list_dannie_strani(vector<sportsmen_strani> sportsmens_strani); // ����� ������ ����������_������
private:
	sportsmen vtoroi_sportsmen;
	sportsmen_strani vtoroi_sportsmen_strani;
	int vibor;
	string k,t,t1;
	float w, g;
};
#endif MENU_H
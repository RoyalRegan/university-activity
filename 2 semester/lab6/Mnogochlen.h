#pragma once
#include <vector>
using namespace std;

class Mnogochlen
{
private:
	vector <double> Mnog;
	friend ostream &operator <<(ostream &os, Mnogochlen mnog);
public:
	Mnogochlen();
	Mnogochlen(vector<double> mnogochlen);
	~Mnogochlen();
	void set_mnogochlen();
	vector<double> get_mnogochlen();
	double znach();
	void podob();
	void operator -();
	void operator <(Mnogochlen mnog);
};


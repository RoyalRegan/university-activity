#pragma once
#include<string>
using namespace std;

void create_file(string file_name,ofstream &write);
void show_file(string file_name, ifstream &read);
void add_entry(string file_name, ofstream &write);
string copy_in_file(string file_name, ifstream &read, ofstream &write);
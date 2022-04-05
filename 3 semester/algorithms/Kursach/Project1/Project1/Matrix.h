#pragma once

ref class Matrix
{
private:
	array <double, 2>^ matrix;
	int row;
	int colomn;
public:
	Matrix();
	Matrix(int r, int c);
	array <double, 2>^ get_array();
	int get_row();
	int get_colomn();
	void randomize();
	void change_matrix(int r, int c);
	void overwrite_cell(int r, int c, double value);
};
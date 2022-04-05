#include "Matrix.h"
#include <stdlib.h>
#include <ctime>
Matrix::Matrix()
{
	matrix = gcnew array<double, 2>(0, 0);
	row = 0;
	colomn = 0;
	srand(time(NULL));
}

Matrix::Matrix(int r, int c)
{
	matrix = gcnew array<double, 2>(r, c);
	row = r;
	colomn = c;
	for (int i = 0; i <row; i++)
	{
		for (int j = 0; j < colomn; j++)
		{
			matrix[i,j] = 0;
		}
	}
}

array <double, 2>^ Matrix::get_array()
{
	return matrix;
}

int Matrix::get_row()
{
	return row;
}

int Matrix::get_colomn()
{
	return colomn;
}

void Matrix::randomize()
{
	for (int i = 0; i <row; i++)
	{
		for (int j = 0; j < colomn; j++)
		{
			matrix[i, j] = rand() % 200 - 99;
		}
	}
}

void Matrix::change_matrix(int r, int c)
{
	Matrix^ new_matrix = gcnew Matrix(r, c);
	for (int i = 0; i <r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			if (i < row && j < colomn)
			{
				new_matrix->get_array()[i, j] = matrix[i, j];
			}	
		}
	}
	matrix = new_matrix->get_array();
	row = r;
	colomn = c;
	delete new_matrix;
}

void Matrix::overwrite_cell(int r, int c,double value)
{
	matrix[r-1, c-1] = value;
}
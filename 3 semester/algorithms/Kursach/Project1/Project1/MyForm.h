#pragma once
#include "Matrix.h"

namespace Project1 {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;
	using namespace System::IO;

	/// <summary>
	/// Сводка для MyForm
	/// </summary>
	public ref class MyForm : public System::Windows::Forms::Form
	{
	public:
		MyForm(void)
		{
			InitializeComponent();
			//
			//TODO: добавьте код конструктора
			//
		}

	protected:
		/// <summary>
		/// Освободить все используемые ресурсы.
		/// </summary>
		~MyForm()
		{
			if (components)
			{
				delete components;
			}
		}

	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::NumericUpDown^  numericUpDown1;
	private: System::Windows::Forms::NumericUpDown^  numericUpDown2;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::GroupBox^  groupBox1;
	private: System::Windows::Forms::GroupBox^  groupBox2;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::GroupBox^  groupBox3;

	private: System::Windows::Forms::TextBox^  textBox1;

	private: System::Windows::Forms::Label^  label6;
	private: System::Windows::Forms::Label^  label7;
	private: System::Windows::Forms::Button^  button2;
	private: System::Windows::Forms::NumericUpDown^  numericUpDown3;
	private: System::Windows::Forms::NumericUpDown^  numericUpDown4;
	private: System::Windows::Forms::GroupBox^  groupBox4;
	private: System::Windows::Forms::Button^  button3;
	private: System::Windows::Forms::RichTextBox^  richTextBox1;

	protected:

	private:
		/// <summary>
		/// Обязательная переменная конструктора.
		/// </summary>
		System::ComponentModel::Container ^components;

#pragma region Windows Form Designer generated code
		/// <summary>
		/// Требуемый метод для поддержки конструктора — не изменяйте 
		/// содержимое этого метода с помощью редактора кода.
		/// </summary>
		void InitializeComponent(void)
		{
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->numericUpDown1 = (gcnew System::Windows::Forms::NumericUpDown());
			this->numericUpDown2 = (gcnew System::Windows::Forms::NumericUpDown());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->groupBox1 = (gcnew System::Windows::Forms::GroupBox());
			this->richTextBox1 = (gcnew System::Windows::Forms::RichTextBox());
			this->groupBox2 = (gcnew System::Windows::Forms::GroupBox());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->groupBox3 = (gcnew System::Windows::Forms::GroupBox());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->label6 = (gcnew System::Windows::Forms::Label());
			this->label7 = (gcnew System::Windows::Forms::Label());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->numericUpDown3 = (gcnew System::Windows::Forms::NumericUpDown());
			this->numericUpDown4 = (gcnew System::Windows::Forms::NumericUpDown());
			this->groupBox4 = (gcnew System::Windows::Forms::GroupBox());
			this->button3 = (gcnew System::Windows::Forms::Button());
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown1))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown2))->BeginInit();
			this->groupBox1->SuspendLayout();
			this->groupBox2->SuspendLayout();
			this->groupBox3->SuspendLayout();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown3))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown4))->BeginInit();
			this->groupBox4->SuspendLayout();
			this->SuspendLayout();
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(23, 80);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(140, 39);
			this->button1->TabIndex = 1;
			this->button1->Text = L"Применить";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &MyForm::button1_Click);
			// 
			// numericUpDown1
			// 
			this->numericUpDown1->Location = System::Drawing::Point(9, 54);
			this->numericUpDown1->Name = L"numericUpDown1";
			this->numericUpDown1->Size = System::Drawing::Size(43, 20);
			this->numericUpDown1->TabIndex = 2;
			this->numericUpDown1->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			// 
			// numericUpDown2
			// 
			this->numericUpDown2->Location = System::Drawing::Point(133, 54);
			this->numericUpDown2->Name = L"numericUpDown2";
			this->numericUpDown2->Size = System::Drawing::Size(43, 20);
			this->numericUpDown2->TabIndex = 3;
			this->numericUpDown2->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(6, 38);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(34, 13);
			this->label2->TabIndex = 4;
			this->label2->Text = L"Ряды";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(125, 38);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(51, 13);
			this->label3->TabIndex = 5;
			this->label3->Text = L"Столбцы";
			// 
			// groupBox1
			// 
			this->groupBox1->Controls->Add(this->richTextBox1);
			this->groupBox1->Location = System::Drawing::Point(12, 9);
			this->groupBox1->Name = L"groupBox1";
			this->groupBox1->Size = System::Drawing::Size(571, 379);
			this->groupBox1->TabIndex = 6;
			this->groupBox1->TabStop = false;
			this->groupBox1->Text = L"Матрица";
			this->groupBox1->Enter += gcnew System::EventHandler(this, &MyForm::groupBox1_Enter);
			// 
			// richTextBox1
			// 
			this->richTextBox1->BorderStyle = System::Windows::Forms::BorderStyle::None;
			this->richTextBox1->Location = System::Drawing::Point(6, 16);
			this->richTextBox1->Margin = System::Windows::Forms::Padding(5);
			this->richTextBox1->Name = L"richTextBox1";
			this->richTextBox1->ReadOnly = true;
			this->richTextBox1->Size = System::Drawing::Size(562, 360);
			this->richTextBox1->TabIndex = 1;
			this->richTextBox1->Text = L"";
			this->richTextBox1->WordWrap = false;
			this->richTextBox1->TextChanged += gcnew System::EventHandler(this, &MyForm::richTextBox1_TextChanged);
			// 
			// groupBox2
			// 
			this->groupBox2->Controls->Add(this->label2);
			this->groupBox2->Controls->Add(this->label3);
			this->groupBox2->Controls->Add(this->button1);
			this->groupBox2->Controls->Add(this->numericUpDown1);
			this->groupBox2->Controls->Add(this->numericUpDown2);
			this->groupBox2->Location = System::Drawing::Point(589, 9);
			this->groupBox2->Name = L"groupBox2";
			this->groupBox2->Size = System::Drawing::Size(182, 139);
			this->groupBox2->TabIndex = 7;
			this->groupBox2->TabStop = false;
			this->groupBox2->Text = L" ";
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Location = System::Drawing::Point(65, 80);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(55, 13);
			this->label4->TabIndex = 0;
			this->label4->Text = L"Значение";
			// 
			// groupBox3
			// 
			this->groupBox3->Controls->Add(this->label4);
			this->groupBox3->Controls->Add(this->textBox1);
			this->groupBox3->Controls->Add(this->label6);
			this->groupBox3->Controls->Add(this->label7);
			this->groupBox3->Controls->Add(this->button2);
			this->groupBox3->Controls->Add(this->numericUpDown3);
			this->groupBox3->Controls->Add(this->numericUpDown4);
			this->groupBox3->Location = System::Drawing::Point(589, 154);
			this->groupBox3->Name = L"groupBox3";
			this->groupBox3->Size = System::Drawing::Size(182, 179);
			this->groupBox3->TabIndex = 8;
			this->groupBox3->TabStop = false;
			this->groupBox3->Text = L"Значение ячейки";
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(43, 96);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(100, 20);
			this->textBox1->TabIndex = 6;
			// 
			// label6
			// 
			this->label6->AutoSize = true;
			this->label6->Location = System::Drawing::Point(6, 38);
			this->label6->Name = L"label6";
			this->label6->Size = System::Drawing::Size(26, 13);
			this->label6->TabIndex = 4;
			this->label6->Text = L"Ряд";
			// 
			// label7
			// 
			this->label7->AutoSize = true;
			this->label7->Location = System::Drawing::Point(127, 38);
			this->label7->Name = L"label7";
			this->label7->Size = System::Drawing::Size(49, 13);
			this->label7->TabIndex = 5;
			this->label7->Text = L"Столбец";
			// 
			// button2
			// 
			this->button2->Location = System::Drawing::Point(23, 122);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(140, 39);
			this->button2->TabIndex = 1;
			this->button2->Text = L"Изменить";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &MyForm::button2_Click);
			// 
			// numericUpDown3
			// 
			this->numericUpDown3->Location = System::Drawing::Point(6, 54);
			this->numericUpDown3->Name = L"numericUpDown3";
			this->numericUpDown3->Size = System::Drawing::Size(43, 20);
			this->numericUpDown3->TabIndex = 2;
			this->numericUpDown3->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			// 
			// numericUpDown4
			// 
			this->numericUpDown4->Location = System::Drawing::Point(133, 54);
			this->numericUpDown4->Name = L"numericUpDown4";
			this->numericUpDown4->Size = System::Drawing::Size(43, 20);
			this->numericUpDown4->TabIndex = 3;
			this->numericUpDown4->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			// 
			// groupBox4
			// 
			this->groupBox4->Controls->Add(this->button3);
			this->groupBox4->Location = System::Drawing::Point(589, 339);
			this->groupBox4->Name = L"groupBox4";
			this->groupBox4->Size = System::Drawing::Size(182, 49);
			this->groupBox4->TabIndex = 9;
			this->groupBox4->TabStop = false;
			this->groupBox4->Text = L"Рандом";
			// 
			// button3
			// 
			this->button3->Location = System::Drawing::Point(23, 14);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(139, 29);
			this->button3->TabIndex = 1;
			this->button3->Text = L"Тык!";
			this->button3->UseVisualStyleBackColor = true;
			this->button3->Click += gcnew System::EventHandler(this, &MyForm::button3_Click);
			// 
			// MyForm
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(779, 394);
			this->Controls->Add(this->groupBox4);
			this->Controls->Add(this->groupBox3);
			this->Controls->Add(this->groupBox2);
			this->Controls->Add(this->groupBox1);
			this->Name = L"MyForm";
			this->Text = L"MyForm";
			this->FormClosing += gcnew System::Windows::Forms::FormClosingEventHandler(this, &MyForm::MyForm_FormClosing);
			this->Load += gcnew System::EventHandler(this, &MyForm::MyForm_Load);
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown1))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown2))->EndInit();
			this->groupBox1->ResumeLayout(false);
			this->groupBox2->ResumeLayout(false);
			this->groupBox2->PerformLayout();
			this->groupBox3->ResumeLayout(false);
			this->groupBox3->PerformLayout();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown3))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown4))->EndInit();
			this->groupBox4->ResumeLayout(false);
			this->ResumeLayout(false);

		}
#pragma endregion
		Matrix^ matrix = gcnew Matrix();

		void paint(int row,int column)
		{
			richTextBox1->Text = "";
			for (int i = 0; i < row; i++)
			{
				for (int j = 0; j < column; j++)
				{
					richTextBox1->Text += matrix->get_array()[i, j]+ "\t"; ;
				}
				richTextBox1->Text += "\n"+"\n"+"\n";
			}
		}

	private: System::Void MyForm_Load(System::Object^  sender, System::EventArgs^  e) 
	{
		StreamReader^ sr = gcnew StreamReader("Матрица.txt");
		if (!sr->EndOfStream)
		{
			int row = Int32::Parse(sr->ReadLine());
			int colomn = Int32::Parse(sr->ReadLine());
			matrix->change_matrix(row, colomn);
			for (int i = 1; i <= row; i++)
			{
				for (int j = 1; j <= colomn; j++)
				{
					matrix->overwrite_cell(i, j, Int32::Parse(sr->ReadLine()));
				}
			}
			numericUpDown1->Value = row;
			numericUpDown2->Value = colomn;
			sr->Close();
			paint(matrix->get_row(), matrix->get_colomn());
		}
		else
		{
			matrix->change_matrix(1, 1);
			paint(matrix->get_row(), matrix->get_colomn());
			numericUpDown1->Value = 1;
			numericUpDown2->Value = 1;
		}
		sr->Close();
	}
	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) 
	{
		if ((Int32::Parse(numericUpDown1->Text) > 0 && (Int32::Parse(numericUpDown2->Text) > 0)))
		{
			matrix->change_matrix(Int32::Parse(numericUpDown1->Text), Int32::Parse(numericUpDown2->Text));
			paint(matrix->get_row(), matrix->get_colomn());
		}
		else
		{
			MessageBox::Show("В матрице должно быть больше нуля строк и столбцов", "Ошибка созданиия", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}
private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) 
{
	if ((Int32::Parse(numericUpDown3->Text) > 0 && (Int32::Parse(numericUpDown4->Text) > 0)))
	{
		if (textBox1->Text != "")
		{
			if (Int32::Parse(numericUpDown3->Text) <= matrix->get_row() && (Int32::Parse(numericUpDown4->Text) <= matrix->get_colomn()))
			{
				matrix->overwrite_cell(Int32::Parse(numericUpDown3->Text), Int32::Parse(numericUpDown4->Text), Double::Parse(textBox1->Text));
				paint(matrix->get_row(), matrix->get_colomn());
			}
			else
			{
				MessageBox::Show("Такой клетки не существет", "Ошибка заполнения", MessageBoxButtons::OK, MessageBoxIcon::Error);
			}
		}
		else
		{
			MessageBox::Show("Введите значение", "Ошибка заполнения", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}
	else
	{
		MessageBox::Show("Номер строки/столбца не может быть 0", "Ошибка заполнения", MessageBoxButtons::OK, MessageBoxIcon::Error);
	}
}
private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e) 
{
	if (matrix->get_row() > 0 && matrix->get_colomn() > 0)
	{
		matrix->randomize();
		paint(matrix->get_row(), matrix->get_colomn());
	}
	else
	{
		MessageBox::Show("Матрицы не существует", "Ошибка заполнения", MessageBoxButtons::OK, MessageBoxIcon::Error);
	}
}
private: System::Void groupBox1_Enter(System::Object^  sender, System::EventArgs^  e) 
{
}
private: System::Void MyForm_FormClosing(System::Object^  sender, System::Windows::Forms::FormClosingEventArgs^  e) 
{
	StreamWriter^ sw = gcnew StreamWriter("Матрица.txt");
	sw->WriteLine(matrix->get_row());
	sw->WriteLine(matrix->get_colomn());
	for (int i = 0; i < matrix->get_row(); i++)
	{
		for (int j = 0; j < matrix->get_colomn(); j++)
		{
			sw->WriteLine(matrix->get_array()[i,j]);
		}
	}
	sw->Close();
}
private: System::Void richTextBox1_TextChanged(System::Object^  sender, System::EventArgs^  e) 
{
}
};
}

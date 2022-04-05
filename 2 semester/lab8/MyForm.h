#pragma once
#include"Unit_Def.h"
namespace Лаба8 {

	using namespace System;
	using namespace System::IO;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

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
	private: System::Windows::Forms::DataGridView^  dataGridView1;
	protected:
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  Column1;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  Column2;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  Column3;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  Column4;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  Column5;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  Column6;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::Button^  button2;
	private: System::Windows::Forms::TextBox^  textBox1;
	private: System::Windows::Forms::TextBox^  textBox2;
	private: System::Windows::Forms::TextBox^  textBox3;
	private: System::Windows::Forms::TextBox^  textBox4;
	private: System::Windows::Forms::TextBox^  textBox5;
	private: System::Windows::Forms::TextBox^  textBox6;
	private: System::Windows::Forms::Button^  button3;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::Label^  label5;
	private: System::Windows::Forms::Label^  label6;
	private: System::Windows::Forms::Button^  button4;
	private: System::Windows::Forms::Button^  button5;
	private: System::Windows::Forms::TextBox^  textBox7;
	private: System::Windows::Forms::TextBox^  textBox8;
	private: System::Windows::Forms::Label^  label7;
	private: System::Windows::Forms::Label^  label8;
	private: System::Windows::Forms::OpenFileDialog^  openFileDialog1;

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
			this->dataGridView1 = (gcnew System::Windows::Forms::DataGridView());
			this->Column1 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->Column2 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->Column3 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->Column4 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->Column5 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->Column6 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->textBox3 = (gcnew System::Windows::Forms::TextBox());
			this->textBox4 = (gcnew System::Windows::Forms::TextBox());
			this->textBox5 = (gcnew System::Windows::Forms::TextBox());
			this->textBox6 = (gcnew System::Windows::Forms::TextBox());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->label6 = (gcnew System::Windows::Forms::Label());
			this->button4 = (gcnew System::Windows::Forms::Button());
			this->button5 = (gcnew System::Windows::Forms::Button());
			this->textBox7 = (gcnew System::Windows::Forms::TextBox());
			this->textBox8 = (gcnew System::Windows::Forms::TextBox());
			this->label7 = (gcnew System::Windows::Forms::Label());
			this->label8 = (gcnew System::Windows::Forms::Label());
			this->openFileDialog1 = (gcnew System::Windows::Forms::OpenFileDialog());
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView1))->BeginInit();
			this->SuspendLayout();
			// 
			// dataGridView1
			// 
			this->dataGridView1->AllowUserToAddRows = false;
			this->dataGridView1->AllowUserToDeleteRows = false;
			this->dataGridView1->ColumnHeadersHeightSizeMode = System::Windows::Forms::DataGridViewColumnHeadersHeightSizeMode::AutoSize;
			this->dataGridView1->Columns->AddRange(gcnew cli::array< System::Windows::Forms::DataGridViewColumn^  >(6) {
				this->Column1,
					this->Column2, this->Column3, this->Column4, this->Column5, this->Column6
			});
			this->dataGridView1->Location = System::Drawing::Point(12, 12);
			this->dataGridView1->Name = L"dataGridView1";
			this->dataGridView1->ReadOnly = true;
			this->dataGridView1->Size = System::Drawing::Size(493, 150);
			this->dataGridView1->TabIndex = 0;
			// 
			// Column1
			// 
			this->Column1->HeaderText = L"Фамилия";
			this->Column1->Name = L"Column1";
			this->Column1->ReadOnly = true;
			// 
			// Column2
			// 
			this->Column2->FillWeight = 200;
			this->Column2->HeaderText = L"Имя";
			this->Column2->Name = L"Column2";
			this->Column2->ReadOnly = true;
			// 
			// Column3
			// 
			this->Column3->HeaderText = L"Дата рождения";
			this->Column3->Name = L"Column3";
			this->Column3->ReadOnly = true;
			// 
			// Column4
			// 
			this->Column4->HeaderText = L"Вес";
			this->Column4->Name = L"Column4";
			this->Column4->ReadOnly = true;
			this->Column4->Width = 50;
			// 
			// Column5
			// 
			this->Column5->HeaderText = L"Рост";
			this->Column5->Name = L"Column5";
			this->Column5->ReadOnly = true;
			this->Column5->Width = 50;
			// 
			// Column6
			// 
			this->Column6->HeaderText = L"Пол";
			this->Column6->Name = L"Column6";
			this->Column6->ReadOnly = true;
			this->Column6->Width = 50;
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(12, 177);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(166, 37);
			this->button1->TabIndex = 1;
			this->button1->Text = L"Вывод записей";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &MyForm::button1_Click);
			// 
			// button2
			// 
			this->button2->Location = System::Drawing::Point(12, 227);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(166, 37);
			this->button2->TabIndex = 2;
			this->button2->Text = L"Создание и добавление структур с бинарного файла\r\n";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &MyForm::button2_Click);
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(540, 12);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(100, 20);
			this->textBox1->TabIndex = 3;
			// 
			// textBox2
			// 
			this->textBox2->Location = System::Drawing::Point(540, 38);
			this->textBox2->Name = L"textBox2";
			this->textBox2->Size = System::Drawing::Size(100, 20);
			this->textBox2->TabIndex = 4;
			// 
			// textBox3
			// 
			this->textBox3->Location = System::Drawing::Point(540, 64);
			this->textBox3->Name = L"textBox3";
			this->textBox3->Size = System::Drawing::Size(100, 20);
			this->textBox3->TabIndex = 5;
			// 
			// textBox4
			// 
			this->textBox4->Location = System::Drawing::Point(540, 90);
			this->textBox4->Name = L"textBox4";
			this->textBox4->Size = System::Drawing::Size(100, 20);
			this->textBox4->TabIndex = 6;
			// 
			// textBox5
			// 
			this->textBox5->Location = System::Drawing::Point(540, 116);
			this->textBox5->Name = L"textBox5";
			this->textBox5->Size = System::Drawing::Size(100, 20);
			this->textBox5->TabIndex = 7;
			// 
			// textBox6
			// 
			this->textBox6->Location = System::Drawing::Point(540, 142);
			this->textBox6->Name = L"textBox6";
			this->textBox6->Size = System::Drawing::Size(100, 20);
			this->textBox6->TabIndex = 8;
			// 
			// button3
			// 
			this->button3->Location = System::Drawing::Point(549, 220);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(82, 28);
			this->button3->TabIndex = 9;
			this->button3->Text = L"Добавить";
			this->button3->UseVisualStyleBackColor = true;
			this->button3->Click += gcnew System::EventHandler(this, &MyForm::button3_Click);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(646, 15);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(56, 13);
			this->label1->TabIndex = 10;
			this->label1->Text = L"Фамилия";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(646, 41);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(29, 13);
			this->label2->TabIndex = 11;
			this->label2->Text = L"Имя";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(646, 67);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(116, 13);
			this->label3->TabIndex = 12;
			this->label3->Text = L"Дата рождения(день)";
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Location = System::Drawing::Point(646, 145);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(26, 13);
			this->label4->TabIndex = 13;
			this->label4->Text = L"Вес";
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Location = System::Drawing::Point(646, 171);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(31, 13);
			this->label5->TabIndex = 14;
			this->label5->Text = L"Рост";
			// 
			// label6
			// 
			this->label6->AutoSize = true;
			this->label6->Location = System::Drawing::Point(646, 197);
			this->label6->Name = L"label6";
			this->label6->Size = System::Drawing::Size(27, 13);
			this->label6->TabIndex = 15;
			this->label6->Text = L"Пол";
			// 
			// button4
			// 
			this->button4->Location = System::Drawing::Point(339, 171);
			this->button4->Name = L"button4";
			this->button4->Size = System::Drawing::Size(166, 37);
			this->button4->TabIndex = 16;
			this->button4->Text = L"Сортировка\r\n(по весу)";
			this->button4->UseVisualStyleBackColor = true;
			this->button4->Click += gcnew System::EventHandler(this, &MyForm::button4_Click);
			// 
			// button5
			// 
			this->button5->Location = System::Drawing::Point(339, 221);
			this->button5->Name = L"button5";
			this->button5->Size = System::Drawing::Size(166, 37);
			this->button5->TabIndex = 17;
			this->button5->Text = L"Список мужчин не старше 22";
			this->button5->UseVisualStyleBackColor = true;
			this->button5->Click += gcnew System::EventHandler(this, &MyForm::button5_Click);
			// 
			// textBox7
			// 
			this->textBox7->Location = System::Drawing::Point(540, 168);
			this->textBox7->Name = L"textBox7";
			this->textBox7->Size = System::Drawing::Size(100, 20);
			this->textBox7->TabIndex = 18;
			// 
			// textBox8
			// 
			this->textBox8->Location = System::Drawing::Point(540, 194);
			this->textBox8->Name = L"textBox8";
			this->textBox8->Size = System::Drawing::Size(100, 20);
			this->textBox8->TabIndex = 19;
			// 
			// label7
			// 
			this->label7->AutoSize = true;
			this->label7->Location = System::Drawing::Point(646, 93);
			this->label7->Name = L"label7";
			this->label7->Size = System::Drawing::Size(124, 13);
			this->label7->TabIndex = 20;
			this->label7->Text = L"Дата рождения(месяц)";
			// 
			// label8
			// 
			this->label8->AutoSize = true;
			this->label8->Location = System::Drawing::Point(646, 119);
			this->label8->Name = L"label8";
			this->label8->Size = System::Drawing::Size(109, 13);
			this->label8->TabIndex = 21;
			this->label8->Text = L"Дата рождения(год)";
			// 
			// openFileDialog1
			// 
			this->openFileDialog1->FileName = L"openFileDialog1";
			// 
			// MyForm
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(800, 276);
			this->Controls->Add(this->label8);
			this->Controls->Add(this->label7);
			this->Controls->Add(this->textBox8);
			this->Controls->Add(this->textBox7);
			this->Controls->Add(this->button5);
			this->Controls->Add(this->button4);
			this->Controls->Add(this->label6);
			this->Controls->Add(this->label5);
			this->Controls->Add(this->label4);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->button3);
			this->Controls->Add(this->textBox6);
			this->Controls->Add(this->textBox5);
			this->Controls->Add(this->textBox4);
			this->Controls->Add(this->textBox3);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->textBox1);
			this->Controls->Add(this->button2);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->dataGridView1);
			this->Name = L"MyForm";
			this->Text = L"MyForm";
			this->Load += gcnew System::EventHandler(this, &MyForm::MyForm_Load);
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView1))->EndInit();
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion

		vector<SportsmenInfo^> Sportsmens;
		vector<SportsmenInfo^> NewSportsmensList;

		bool Proverka(BornData^ a)
		{
			if ((a->year >= 1997 && a->month <= 12 && a->day <= 30) || (a->year > 1997))
			{
				return true;
			}
			return false;
		}

	private: System::Void MyForm_Load(System::Object^  sender, System::EventArgs^  e)
	{

	}
	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e)
	{
		dataGridView1->Rows->Clear();
		while (dataGridView1->RowCount < Sportsmens.size())
		{
			dataGridView1->Rows->Add();
		}
		for (int i = 0; i < dataGridView1->RowCount; i++)
		{
			dataGridView1->Rows[i]->Cells[0]->Value = Sportsmens[i]->SecondName;
			dataGridView1->Rows[i]->Cells[1]->Value = Sportsmens[i]->FisrtName;
			dataGridView1->Rows[i]->Cells[2]->Value = (Sportsmens[i]->data->day + "/" + Sportsmens[i]->data->month + "/" + Sportsmens[i]->data->year);
			dataGridView1->Rows[i]->Cells[3]->Value = Sportsmens[i]->Weight.ToString();
			dataGridView1->Rows[i]->Cells[4]->Value = Sportsmens[i]->Growth.ToString();
			dataGridView1->Rows[i]->Cells[5]->Value = Sportsmens[i]->Sex;
		}
	}
	private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (openFileDialog1->ShowDialog() == System::Windows::Forms::DialogResult::OK)
		{
			StreamReader^ sr = gcnew StreamReader(openFileDialog1->FileName);
			BinaryWriter^ bw = gcnew BinaryWriter(File::OpenWrite("Binary.txt"));
			while (!sr->EndOfStream)
			{
				bw->Write(sr->ReadLine());
				bw->Write(sr->ReadLine());
				bw->Write(sr->ReadLine());
				bw->Write(sr->ReadLine());
				bw->Write(sr->ReadLine());
				bw->Write(sr->ReadLine());
				bw->Write(sr->ReadLine());
				bw->Write(sr->ReadLine());
			}
			delete (IDisposable^)sr;
			delete (IDisposable^)bw;
			BinaryReader^br = gcnew BinaryReader(File::OpenRead("Binary.txt"));
			SportsmenInfo^ Sportsmen_test = gcnew SportsmenInfo;
			while (br->PeekChar()>0)
			{	
				
				Sportsmen_test->SecondName = br->ReadString();
				Sportsmen_test->FisrtName = br->ReadString();
				Int32::TryParse(br->ReadString(),Sportsmen_test->data->day);
				Int32::TryParse(br->ReadString(), Sportsmen_test->data->month);
				Int32::TryParse(br->ReadString(), Sportsmen_test->data->year);
				float::TryParse(br->ReadString(), Sportsmen_test->Weight);
				float::TryParse(br->ReadString(), Sportsmen_test->Growth);
				Sportsmen_test->Sex = br->ReadString();
				Sportsmens.push_back(Sportsmen_test);
				Sportsmen_test = gcnew SportsmenInfo;
			}
			delete (IDisposable^)br;
		}
	}
	private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (textBox1->Text != ""&&textBox2->Text != ""&&textBox3->Text != ""&&textBox4->Text != ""&&textBox5->Text != ""&&textBox6->Text != "")
		{
			SportsmenInfo^ Sportsmen_test = gcnew SportsmenInfo;
			Sportsmen_test->data->day = -1;
			Sportsmen_test->data->month = -1;
			Sportsmen_test->data->year = -1;
			Sportsmen_test->Weight = -1;
			Sportsmen_test->Growth = -1;
			Sportsmen_test->SecondName = textBox1->Text;
			Sportsmen_test->FisrtName = textBox2->Text;
			Int32::TryParse(textBox3->Text, Sportsmen_test->data->day);
			Int32::TryParse(textBox4->Text, Sportsmen_test->data->month);
			Int32::TryParse(textBox5->Text, Sportsmen_test->data->year);
			float::TryParse(textBox6->Text, Sportsmen_test->Weight);
			float::TryParse(textBox7->Text, Sportsmen_test->Growth);
			Sportsmen_test->Sex = textBox8->Text;
			if (Sportsmen_test->data->day > 0 && Sportsmen_test->data->month > 0 && Sportsmen_test->data->year > 0 && Sportsmen_test->Weight > 0 && Sportsmen_test->Growth > 0)
			{
				dataGridView1->Rows->Clear();
				dataGridView1->Rows->Add();
				dataGridView1->Rows[0]->Cells[0]->Value = Sportsmen_test->SecondName;
				dataGridView1->Rows[0]->Cells[1]->Value = Sportsmen_test->FisrtName;
				dataGridView1->Rows[0]->Cells[2]->Value = (Sportsmen_test->data->day + "/" + Sportsmen_test->data->month + "/" + Sportsmen_test->data->year);
				dataGridView1->Rows[0]->Cells[3]->Value = Sportsmen_test->Weight.ToString();
				dataGridView1->Rows[0]->Cells[4]->Value = Sportsmen_test->Growth.ToString();
				dataGridView1->Rows[0]->Cells[5]->Value = Sportsmen_test->Sex;
				Sportsmens.push_back(Sportsmen_test);
				MessageBox::Show("Спортсмен добавлен");
			}
			else
			{
				MessageBox::Show("Заполните корректно поля");
			}
		}
		else
		{
			MessageBox::Show("Заполните корректно поля");
		}
	}
	private: System::Void button4_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (Sportsmens.size() > 1)
		{
			for (unsigned int i = 0; i < Sportsmens.size() - 1; i++)
			{
				for (unsigned int j = 0; j < Sportsmens.size() - i - 1; j++)
				{
					if (Sportsmens[j]->Weight < Sportsmens[j + 1]->Weight)
					{
						SportsmenInfo^ b = Sportsmens[j];
						Sportsmens[j] = Sportsmens[j + 1];
						Sportsmens[j + 1] = b;
					}
				}
			}
		}
	}

	private: System::Void button5_Click(System::Object^  sender, System::EventArgs^  e)
	{
		for (unsigned int i = 0; i < Sportsmens.size(); i++)
		{
			if ((Sportsmens[i]->Sex == "M" || Sportsmens[i]->Sex == "М") && (Proverka(Sportsmens[i]->data)))
			{
				NewSportsmensList.push_back(Sportsmens[i]);
			}
		}
		dataGridView1->Rows->Clear();
		while (dataGridView1->RowCount < NewSportsmensList.size())
		{
			dataGridView1->Rows->Add();
		}
		for (int i = 0; i < dataGridView1->RowCount; i++)
		{
			dataGridView1->Rows[i]->Cells[0]->Value = NewSportsmensList[i]->SecondName;
			dataGridView1->Rows[i]->Cells[1]->Value = NewSportsmensList[i]->FisrtName;
			dataGridView1->Rows[i]->Cells[2]->Value = (NewSportsmensList[i]->data->day + "/" + NewSportsmensList[i]->data->month + "/" + NewSportsmensList[i]->data->year);
			dataGridView1->Rows[i]->Cells[3]->Value = NewSportsmensList[i]->Weight.ToString();
			dataGridView1->Rows[i]->Cells[4]->Value = NewSportsmensList[i]->Growth.ToString();
			dataGridView1->Rows[i]->Cells[5]->Value = NewSportsmensList[i]->Sex;
		}
		NewSportsmensList.clear();
	}
	};
}
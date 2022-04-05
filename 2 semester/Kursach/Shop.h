#pragma once
#include "Data_base.h"
#include"PIN.h"
namespace Курсач {

	using namespace System;
	using namespace System::IO;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Сводка для Shop
	/// </summary>
	public ref class Shop : public System::Windows::Forms::Form
	{
	public:
		Shop(void)
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
		~Shop()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::Label^  label5;
	protected:
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::Button^  button3;
	private: System::Windows::Forms::Button^  button2;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::ListBox^  listBox1;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::ComboBox^  comboBox1;

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
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->listBox1 = (gcnew System::Windows::Forms::ListBox());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->comboBox1 = (gcnew System::Windows::Forms::ComboBox());
			this->SuspendLayout();
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label5->Location = System::Drawing::Point(258, 139);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(127, 16);
			this->label5->TabIndex = 26;
			this->label5->Text = L"Сумма к оплате:  0";
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label4->Location = System::Drawing::Point(12, 131);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(160, 20);
			this->label4->TabIndex = 25;
			this->label4->Text = L"Добавить в корзину";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label3->Location = System::Drawing::Point(17, 32);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(0, 20);
			this->label3->TabIndex = 24;
			// 
			// button3
			// 
			this->button3->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button3->Location = System::Drawing::Point(170, 252);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(105, 39);
			this->button3->TabIndex = 23;
			this->button3->Text = L"Оплатить";
			this->button3->UseVisualStyleBackColor = true;
			this->button3->Click += gcnew System::EventHandler(this, &Shop::button3_Click);
			// 
			// button2
			// 
			this->button2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button2->Location = System::Drawing::Point(261, 190);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(123, 29);
			this->button2->TabIndex = 22;
			this->button2->Text = L"Удалить";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &Shop::button2_Click);
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label2->Location = System::Drawing::Point(257, 9);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(72, 20);
			this->label2->TabIndex = 21;
			this->label2->Text = L"Корзина";
			// 
			// listBox1
			// 
			this->listBox1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->listBox1->FormattingEnabled = true;
			this->listBox1->ItemHeight = 20;
			this->listBox1->Location = System::Drawing::Point(261, 32);
			this->listBox1->Name = L"listBox1";
			this->listBox1->Size = System::Drawing::Size(125, 104);
			this->listBox1->TabIndex = 20;
			// 
			// button1
			// 
			this->button1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button1->Location = System::Drawing::Point(16, 188);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(123, 31);
			this->button1->TabIndex = 19;
			this->button1->Text = L"Добавить";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &Shop::button1_Click);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label1->Location = System::Drawing::Point(12, 9);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(80, 20);
			this->label1->TabIndex = 18;
			this->label1->Text = L"Расценка";
			// 
			// comboBox1
			// 
			this->comboBox1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->comboBox1->FormattingEnabled = true;
			this->comboBox1->Location = System::Drawing::Point(16, 154);
			this->comboBox1->Name = L"comboBox1";
			this->comboBox1->Size = System::Drawing::Size(160, 28);
			this->comboBox1->TabIndex = 17;
			this->comboBox1->Text = L"Выберите товар";
			// 
			// Shop
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClientSize = System::Drawing::Size(409, 310);
			this->Controls->Add(this->label5);
			this->Controls->Add(this->label4);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->button3);
			this->Controls->Add(this->button2);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->listBox1);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->comboBox1);
			this->Name = L"Shop";
			this->StartPosition = System::Windows::Forms::FormStartPosition::CenterScreen;
			this->Text = L"Shop";
			this->FormClosed += gcnew System::Windows::Forms::FormClosedEventHandler(this, &Shop::Shop_FormClosed);
			this->Load += gcnew System::EventHandler(this, &Shop::Shop_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void Shop_Load(System::Object^  sender, System::EventArgs^  e) 
	{
		StreamReader^ sr = gcnew StreamReader("Товары.txt");
		while (!sr->EndOfStream)
		{
			Product ^product = gcnew Product(sr->ReadLine(), Double::Parse(sr->ReadLine()));
			Data_base::products->add_product(product);
		}
		delete (IDisposable^)sr;

		for (int i = 0; i < Data_base::products->get_product().size(); i++)
		{
			comboBox1->Items->Add(Data_base::products->get_product()[i]->get_name());
		}

		for (int i = 0; i < Data_base::products->get_product().size(); i++)
		{
			label3->Text += Data_base::products->get_product()[i]->get_name() + " - " + Data_base::products->get_product()[i]->get_price() + "р" + "\n";
		}
	}

	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (comboBox1->SelectedIndex != -1)
		{
			listBox1->Items->Add(comboBox1->SelectedItem);
			Data_base::korzin->add_product(Data_base::products->search_product(comboBox1->SelectedItem->ToString()));
			label5->Text = "Сумма к оплате: " + Data_base::korzin->get_full_price().ToString();
		}
		else
		{
			MessageBox::Show("Выберите товар", "Ошибка", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}

	private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (listBox1->SelectedIndex != -1)
		{
			Data_base::korzin->rem_product(listBox1->SelectedItem->ToString());
			listBox1->Items->Remove(listBox1->SelectedItem);
			label5->Text = "Сумма к оплате: " + Data_base::korzin->get_full_price().ToString();
		}
		else
		{
			MessageBox::Show("Выберите товар", "Ошибка", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}

	private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e)
	{
		double money;
		if (listBox1->Items->Count > 0)
		{
			money = Data_base::korzin->get_full_price();
			if ((Data_base::client_karta->get_money() - money) > -1)
			{
				if (money < 5001)
				{
					PIN^ forma6 = gcnew PIN;
					forma6->ShowDialog();
					if (PIN::check_pin)
					{
						Data_base::client_karta->payment(money);
						Data_base::client_karta->add_transaction(-1 * money);
						PIN::check_pin = false;
						MessageBox::Show("Оплата совершена");
						this->Close();
					}
				}
				else
				{
					Data_base::client_karta->set_block(true);
					MessageBox::Show("Карта была заблокирована оператором за превышение платежа", "Блокировка", MessageBoxButtons::OK, MessageBoxIcon::Information);
					this->Close();
				}
			}
			else
			{
				MessageBox::Show("Недостаточно средств", "Ошибка оплаты", MessageBoxButtons::OK, MessageBoxIcon::Error);
			}
		}
		else
		{
			MessageBox::Show("Корзина пуста", "Ошибка оплаты", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}
private: System::Void Shop_FormClosed(System::Object^  sender, System::Windows::Forms::FormClosedEventArgs^  e) 
{
	Data_base::products = gcnew Store();
	Data_base::korzin = gcnew Basket();
}
};
}

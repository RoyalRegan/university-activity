#include "Transfer.h"

using namespace System;
using namespace System::Windows::Forms;
[STAThreadAttribute]
void Main4(array<String^>^ args)
{
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false);
	������::Transfer form;
	Application::Run(%form);
}
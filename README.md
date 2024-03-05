# Вычилитель отличий  
Описание проекта  
Проект "Вычилитель отличий" представляет собой CLI-утилиту, предназначенную для сравнения двух конфигурационных файлов в форматах JSON,YAML или YML. Утилита осуществляет парсинг файлов, сравнивает полученные данные и строит дифф в виде изменений между файлами.  

Установка  
Для установки приложения, выполните следующие шаги:  

Склонируйте репозиторий:  

[![Copy Code](https://img.shields.io/badge/Copy%20Code-Click%20to%20Copy-blue?style=flat)](javascript:void(0))  
Перейдите в директорию проекта:  


Соберите и установите приложение:


Использование
CLI-утилита позволяет сравнивать два конфигурационных файла с использованием командной строки. Для получения справки о доступных опциях, используйте команду:


Пример использования

Опции
-f, --format: Опция для выбора формата файлов (JSON или YAML).

[![Actions Status](https://github.com/SpaceLudens/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/SpaceLudens/java-project-71/actions)
[![Actions Status](https://github.com/SpaceLudens/java-project-71/actions/workflows/main.yml/badge.svg)]
[![Maintainability](https://api.codeclimate.com/v1/badges/44471e5730a3454da086/maintainability)](https://codeclimate.com/github/SpaceLudens/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/44471e5730a3454da086/test_coverage)](https://codeclimate.com/github/SpaceLudens/java-project-71/test_coverage)

Аскинема с примером работы пакета на шаге 5: [https://asciinema.org/a/jyw5T7JuN1XqWfDzdtLiRB3y4](https://asciinema.org/a/vMWVFsx3Afy2ggOdQg0gBAx0O)  
Аскинема с примером работы пакета на шаге 7: [https://asciinema.org/a/j42RQWuhXnbMDCT8nWNo0V7EA](https://asciinema.org/a/fxluLZJcBu1h42zsZ4LUkt5XE)  
Аскинема с примером работы пакета на шаге 8: [https://asciinema.org/a/WdzjPjKZ1lWF4r595b71IUfJa](https://asciinema.org/a/CPY8llW7qFyE4gF0gzexFEAKF)  
Аскинема с примером работы пакета на шаге 9: https://asciinema.org/a/vp2bDdbDoe8H81TneyjB2vvt2  
Аскинема с примером работы пакета на шаге 10 :https://asciinema.org/a/mGH6B7DIyYLHINHGp7goDizYW  

<script>
  document.addEventListener('DOMContentLoaded', function () {
    var copyCodeBtn = document.querySelector('.copy-code-btn');

    copyCodeBtn.addEventListener('click', function() {
      var codeToCopy = 'https://github.com/SpaceLudens/java-project-71.git';
      
      var textArea = document.createElement("textarea");
      textArea.value = codeToCopy;
      document.body.appendChild(textArea);

      textArea.select();
      document.execCommand('copy');

      document.body.removeChild(textArea);
    });
  });
</script>

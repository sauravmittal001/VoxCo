![alt text](https://github.com/sauravmittal001/VoxCo/blob/master/MyApplication2/app/src/main/ic_launcher_new2-web.png)
# Live Transcribe App

> Transcription of spoken words into text and alerts for risky situations

## Table of Contents

- [Features](#features)
- [Activities](#activities)
- [Installation](#installation)
- [About](#about)
---

### 🌟 Features

- Transcription of spoken words
- Saving text for future reference
- Sound loudness (dB) meter
- Bluetooth connection
- Sound recorder

|  ![alt text](https://github.com/sauravmittal001/VoxCo/blob/master/img/screenshot1.jpeg)  |  ![alt text](https://github.com/sauravmittal001/VoxCo/blob/master/img/screenshot2.jpeg)  |  ![alt text](https://github.com/sauravmittal001/VoxCo/blob/master/img/screenshot3.jpeg)  |
| ----------- | ----------- | ----------- |
| ![alt text](https://github.com/sauravmittal001/VoxCo/blob/master/img/screenshot4.jpeg) | ![alt text](https://github.com/sauravmittal001/VoxCo/blob/master/img/screenshot5.jpeg) | ![alt text](https://github.com/sauravmittal001/VoxCo/blob/master/img/screenshot6.jpeg) |

### ✨ Activities 

- Splash Screen Activity
- Home Activity
- Conference Activity
- Files Activity
- Outdoor/Indoor Activity
- Bluetooth Activity
- Files Activity
- Record Activity

---

## 🚀 Installation

**All the `code` required to get started**

### Clone

- Clone this repo to your local machine using `https://github.com/sauravmittal001/VoxCo`

### Setup

> update and install git

```shell
$ ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
$ brew install git
$ git --version
```

> config account

```shell
$ git config --global user.name "Your Name"
$ git config --global user.email "Your Email"
$ git config --list
```

> clone repo

```shell
$ git init
$ git clone https://github.com/sauravmittal001/VoxCo
```

---
## 📃 About
> I originally made this app as a part of a bigger research project which eventually subsided due to some reasons.

**Idea: Using microphones to receiving words from two persons simultaneously, separating those mixed speech signals and converting it into text will enable a person with hearing impairment to engage in a group conversation comfortably. Additionally, saving the conversation if he/she misses something for future reference would also help.**

The project went through multiple phases, and the solution got re-shaped as it proceeded. The PPT and pdf of the initial proposal can be found [here](https://github.com/sauravmittal001/VoxCo/blob/master/DISA%20PPT.pdf) and [here](https://github.com/sauravmittal001/VoxCo/blob/master/Project%20VoxCo%20proposal.pdf). TL;DR, we were trying to build a device for hearing impaired persons by using the Blind Source Separation. The full project setup and theory can be understood [here](https://www.diva-portal.org/smash/get/diva2:830315/FULLTEXT01.pdf).
The project involved: 
- Separating two independent mixed sound signals into original sound signals by maximising non-Gaussianity.
- Implementing Fast ICA algorithm for component extraction in MATLAB through fixed-point iteration scheme.
- Involved Performing pre-processing and pre-whitening of centred data by eigenvalue decomposition of the covariance matrix.

The app's function was to receive those processed and separated speech signals into the hearing impaired person's device and displaying it as text. (Along with other features)

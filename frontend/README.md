# Trade Suite

Trade Suite is a **versioned playbook, trade journal, and behavioral analytics platform** for discretionary traders.

It helps traders answer one critical question:

> **Is my strategy failing, or is my execution failing?**

---

## 🎯 Core Features

### 🧠 Versioned Playbook
- Define trading setups using reusable rules
- Organize setups into families and variants
- Track strategy evolution using **setup versions**
- Define multiple **ranks (A+, A, B+) per version**

---

### 📓 Trade Journaling
- Record trades with:
  - primary setup (version + rank)
  - secondary setups (confluence)
  - instrument, direction, timestamp
  - optional session tracking
- Separate **BACKTEST vs LIVE trades**

---

### 📊 Performance Tracking
- expectedR → planned trade outcome
- realizedR → actual result
- fullMoveR → maximum available move

👉 Enables **opportunity capture analysis**

---

### 🧠 Behavioral Tracking
- Track rule adherence
- Record mistakes and discipline issues
- Capture emotions (before, during, after)

---

### 🔍 Analytics (Phase 1)
- Setup performance by:
  - family
  - variant
  - version
  - rank
- Backtest vs live comparison
- Opportunity capture metrics
- Rule adherence insights

---

## 🧩 Core Concept

Trade Suite separates:

- **Strategy Performance (clean)**
- **Trader Execution (messy)**

So you can identify:
- if your system works
- or if your behavior needs improvement

---

## 🧱 System Architecture (Phase 1)

- Backend: Java + Spring Boot
- Database: Relational (PostgreSQL planned)
- Frontend: Next.js (in progress)

---

## 🗂️ Database Schema

![Database Schema](docs/diagrams/database-schema.png)

---

## 🚧 Project Status

Phase 1 (MVP) in development:

- [x] Requirements defined  
- [x] Database schema designed  
- [ ] Core domain entities (in progress)  
- [ ] Trade journaling  
- [ ] Analytics engine  
- [ ] UI  

---

## 🧠 One-Line Definition

**Trade Suite is a system that helps traders improve by comparing strategy, execution, and opportunity.**
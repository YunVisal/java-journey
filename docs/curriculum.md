# 18-Month Java Curriculum: Junior to Mid-Level

Oct 8, 2026 · @Visal Yun

## Overview

Goal: move from junior (basic Java syntax) to a mid-level Java backend role at an enterprise company by **April 2028**, with 3 portfolio projects and interview readiness.

**Weekly time budget:** about 10 hours — 1–1.5 hours on weekdays plus 3–4 hours on one weekend day. If a week slips, push the plan back rather than skipping topics.

**How each week works:**

1. Learn the topic (docs, a book chapter or a course section) — about 40% of the time.
2. Write code for it yourself and push it to GitHub — about 60% of the time.
3. On Sunday, explain the week's topic out loud in 2 minutes, as you would in an interview.

**The five phases:**

1. Months 1–3 (Oct–Dec 2026): Core Java and OOP
2. Months 4–6 (Jan–Mar 2027): SQL, Spring Boot, Project 1
3. Months 7–10 (Apr–Jul 2027): Security, testing, Docker, CI, Project 2
4. Months 11–14 (Aug–Nov 2027): Microservices, Kafka, caching, concurrency, JVM, cloud, Project 3
5. Months 15–18 (Dec 2027–Mar 2028): Interview prep and job search

**Running in parallel:** from Phase 3 on, solve 2 LeetCode problems a week, so coding interviews are not crammed at the end. At work, ask for tasks that touch databases, APIs or bug fixes — real experience counts more on a CV than personal projects.

## Phase 1 — Core Java & OOP (Months 1–3)

By the end of December 2026 you write clean object-oriented Java, use collections and streams fluently, and test your code with JUnit.

| Week | Topic | Practice |
| --- | --- | --- |
| 1 | Setup: JDK 25, IntelliJ, Git (commit, branch, merge, push to GitHub) | Create a GitHub repo for this whole curriculum |
| 2 | Classes, objects, constructors, `this`, access modifiers, encapsulation | Model a `BankAccount` with private fields and validation |
| 3 | Inheritance, `super`, method overriding, polymorphism | Build an `Employee` → `Manager` / `Engineer` hierarchy |
| 4 | Abstract classes, interfaces, default methods, composition over inheritance | Refactor week 3 to use interfaces |
| 5 | Strings, `StringBuilder`, wrapper classes, `equals` / `hashCode`, immutability | Write an immutable `Money` class |
| 6 | Exceptions: checked vs unchecked, try-with-resources, custom exceptions | Add custom exceptions to `BankAccount` |
| 7 | Collections I: `List`, `ArrayList` vs `LinkedList`, `Set`, `HashSet`, `TreeSet` | Remove duplicates, sort a contact list |
| 8 | Collections II: `Map`, how `HashMap` works inside, `Comparable` / `Comparator` | Word-frequency counter |
| 9 | Generics: type parameters, bounded types, wildcards | Write a generic `Repository<T, ID>` |
| 10 | Lambdas, functional interfaces, method references, `Optional` | Rewrite loops from weeks 7–8 with lambdas |
| 11 | Streams: `map`, `filter`, `reduce`, `collect`, `groupingBy` | Sales report from a list of orders |
| 12 | Modern Java: records, enums, switch expressions, text blocks, `var`, `java.time` | Convert DTO-style classes to records |
| 13 | Maven or Gradle basics, JUnit 5 unit tests | **Mini project:** console library manager with tests |

**Phase 1 done when:**

- [ ] You can explain the 4 OOP pillars with your own code examples
- [ ] You can explain how `HashMap` stores and finds a key
- [ ] Mini project is on GitHub with a README and passing tests

## Phase 2 — SQL & Spring Boot (Months 4–6)

By the end of March 2027 you build a working REST API backed by a real database — the core skill of every enterprise Java job.

| Week | Topic | Practice |
| --- | --- | --- |
| 14 | SQL basics: `SELECT`, `WHERE`, `ORDER BY`, `GROUP BY`, aggregates | Install PostgreSQL; query a sample database |
| 15 | Joins, subqueries, normalization, schema design | Design tables for a library system |
| 16 | Indexes, transactions, ACID, isolation levels (basics) | Compare a query's speed with and without an index (`EXPLAIN`) |
| 17 | JDBC basics; how the web works: HTTP, REST, JSON, status codes | Call a public API with Postman |
| 18 | Spring core: IoC, dependency injection, beans, `@Service`, configuration, profiles | Small app wiring 3 beans together |
| 19 | Spring Boot: REST controllers, request mapping, DTOs | Hello-world CRUD API (in-memory list) |
| 20 | Validation (`@Valid`), global error handling (`@ControllerAdvice`), logging (SLF4J) | Add validation and clean error JSON |
| 21 | Spring Data JPA: entities, repositories, derived queries | Connect week 19 API to PostgreSQL |
| 22 | JPA relationships, lazy vs eager loading, the N+1 problem, `@Transactional` | Reproduce and fix an N+1 query |
| 23 | Pagination and sorting, Flyway migrations, layered architecture | Add paging and migrations |
| 24–26 | **Project 1** | See below |

**Project 1 — Library / Inventory Management API**

- Entities: books (or products), categories, members, loans (or stock movements)
- Full CRUD with validation, paging, search and filtering
- PostgreSQL with Flyway migrations
- Clean layers: controller → service → repository, DTOs separate from entities
- Unit tests for services, a README with setup steps and example requests

**Phase 2 done when:**

- [ ] You can write a 3-table join without looking it up
- [ ] You can explain dependency injection and what `@Transactional` does
- [ ] Project 1 runs locally from the README instructions

## Phase 3 — Security, Testing, Docker & CI (Months 7–10)

By the end of July 2027 your code looks like enterprise code: secured, tested, containerized and built automatically.

| Week | Topic | Practice |
| --- | --- | --- |
| 27–28 | Spring Security: filter chain, authentication, password hashing | Add login to Project 1 |
| 29–30 | JWT authentication, role-based authorization, OAuth2 concepts | Admin-only vs user endpoints |
| 31 | Mockito: mocks, stubs, verifying calls | Unit-test every Project 1 service |
| 32 | Integration tests: `@SpringBootTest`, MockMvc, Testcontainers | Test the API against a real PostgreSQL container |
| 33 | Design patterns (Builder, Factory, Strategy, Observer), SOLID, clean code | Refactor one messy class from earlier work |
| 34 | Docker: images, containers, Dockerfile, Docker Compose | Run app + PostgreSQL with one `docker compose up` |
| 35 | CI with GitHub Actions: build, test, coverage (JaCoCo) | Pipeline runs on every push |
| 36 | API docs (OpenAPI / Swagger), API versioning, Linux command basics | Publish Swagger UI for Project 1 |
| 37–43 | **Project 2** | See below |

**Project 2 — E-commerce Backend**

- Users, products, cart, orders, a mock payment step, order status flow
- JWT login with customer and admin roles
- Unit + integration tests, at least 70% coverage
- Docker Compose setup and a GitHub Actions pipeline
- Swagger docs and a README with an architecture overview

**Phase 3 done when:**

- [ ] You can explain how a JWT request is authenticated, step by step
- [ ] You know when to use a unit test vs an integration test
- [ ] Project 2 builds and tests green in CI

## Phase 4 — Microservices, Concurrency, JVM & Cloud (Months 11–14)

By the end of November 2027 you understand how enterprise systems are split, connected and run in production.

| Week | Topic | Practice |
| --- | --- | --- |
| 44–45 | Microservices: monolith vs microservices, service boundaries, API gateway, service discovery | Draw how you would split Project 2 |
| 46 | Service-to-service calls (RestClient, OpenFeign); resilience with Resilience4j: retry, circuit breaker, timeout | Call a failing service safely |
| 47–48 | Kafka: topics, partitions, consumer groups, Spring Kafka, event-driven design | Publish an `OrderCreated` event and consume it |
| 49 | Redis caching with Spring Cache, cache invalidation | Cache product lookups; measure the speed-up |
| 50–51 | Concurrency: threads, `ExecutorService`, `CompletableFuture`, locks, concurrent collections, virtual threads | Run parallel API calls and combine the results |
| 52 | JVM: heap vs stack, garbage collection basics, profiling with VisualVM or JFR | Find a memory leak in a sample app |
| 53 | Observability: Spring Actuator, structured logging, metrics (Micrometer, Prometheus) | Add health checks and metrics |
| 54 | Cloud basics (AWS): EC2, RDS, S3, IAM | Deploy Project 2 on the free tier |
| 55 | Kubernetes basics: pods, deployments, services (minikube) | Run your app on local Kubernetes |
| 56–60 | **Project 3** | See below |

**Project 3 — Order Processing Microservices**

- Split Project 2 into 3 services: order, inventory, notification
- Services communicate through Kafka events plus one REST call
- Redis cache, Resilience4j on the REST call, Actuator health checks
- Everything runs with Docker Compose; at least one service deployed to the cloud
- README with an architecture diagram and the reasons for your design choices

**Phase 4 done when:**

- [ ] You can explain the trade-offs of microservices vs a monolith
- [ ] You can explain how Kafka consumer groups share work
- [ ] You can explain a race condition and two ways to prevent it

## Phase 5 — Interview Prep & Job Search (Months 15–18)

From December 2027 to March 2028 you turn your skills into offers. Start applying in week 69; don't wait until you feel 100% ready.

| Week | Focus | Output |
| --- | --- | --- |
| 61–64 | Java core + Spring interview questions: collections, concurrency, JVM, Spring internals, JPA, transactions | Your own Q&A notes, 100+ questions |
| 65–68 | System design basics: load balancing, caching, database scaling, queues; practice designing a URL shortener, an order system and a notification system | 3 written designs with diagrams |
| 61–72 | Coding: 3–4 LeetCode problems a week (arrays, hash maps, two pointers, sliding window, stacks, trees, BFS / DFS) | About 50 problems solved in this phase |
| 69–70 | CV, LinkedIn and GitHub polish; 4 STAR stories (ownership, production bug, disagreement, learning fast) | CV with impact bullets and numbers |
| 71–72 | Mock interviews (friends, online platforms); apply to 5–10 companies a week | Applications tracked in a spreadsheet |
| 73–78 | Interviews, follow-ups, salary negotiation, decision | **Offer accepted** |

**CV tip:** describe results, not duties. "Built an order API with JWT auth, 75% test coverage, CI/CD and Docker" beats "Worked with Spring Boot."

**Phase 5 done when:**

- [ ] You can design a simple system on a whiteboard in 30 minutes
- [ ] You can solve most medium LeetCode problems in 40 minutes
- [ ] You have a mid-level Java offer

## Resources & Milestones

Use one main resource per topic. Switching between too many courses is the most common way to lose months.

| Area | Resource |
| --- | --- |
| Core Java | *Head First Java* (3rd ed.), then *Effective Java* (Joshua Bloch) in Phase 3 |
| Spring | [Spring guides](https://spring.io/guides), [Baeldung](https://www.baeldung.com) tutorials |
| SQL | PostgreSQL official tutorial, SQL practice sites such as SQLBolt |
| Roadmap | [roadmap.sh/java](https://roadmap.sh/java) and [roadmap.sh/spring-boot](https://roadmap.sh/spring-boot) |
| Coding interviews | [NeetCode](https://neetcode.io) problem list on LeetCode |
| System design | *System Design Interview Vol. 1* (Alex Xu); later *Designing Data-Intensive Applications* |
| Docker / Kubernetes / AWS | Official getting-started docs, AWS free tier |

Resource names are from general knowledge, not checked today; editions may have changed.

**Milestones**

- [ ] Dec 2026 — Phase 1 done, mini project on GitHub
- [ ] Mar 2027 — Project 1 (Library / Inventory API) finished
- [ ] Jul 2027 — Project 2 (E-commerce backend) with security, tests, Docker, CI
- [ ] Nov 2027 — Project 3 (microservices) deployed to the cloud
- [ ] Feb 2028 — CV updated, start applying
- [ ] Apr 2028 — Mid-level Java offer accepted

import React from "react";

import styles from "../styles/Home.module.css";
import { Form } from "../components/Form";
import { Result } from "../components/Result";

export default function Home() {
  const [result, setResult] = React.useState(null);
  const [formEntry, setFormEntry] = React.useState(null);

  return (
    <div className={styles.container}>
      {result === null ? (
        <div className={styles.main}>
          <div className={styles.center}>
            <h1 className={styles.title}>Pokémon Fight Simulator</h1>
          </div>
          <Form setResult={setResult} setFormEntry={setFormEntry} />
        </div>
      ) : (
        <Result result={result} formEntry={formEntry} setResult={setResult} />
      )}
    </div>
  );
}
